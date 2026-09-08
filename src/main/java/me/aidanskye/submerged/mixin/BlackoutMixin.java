package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.doctor4t.wathe.cca.WorldBlackoutComponent;
import dev.doctor4t.wathe.game.GameConstants;
import dev.doctor4t.wathe.index.WatheProperties;
import me.aidanskye.submerged.Submerged;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(WorldBlackoutComponent.class)
public abstract class BlackoutMixin {
    @Mutable
    @Final
    @Shadow
    private final World world;
    @Shadow
    private final List<WorldBlackoutComponent.BlackoutDetails> blackouts = new ArrayList<>();
    @Shadow
    private int ticks = 0;

    protected BlackoutMixin(World world) {
        this.world = world;
    }

    @ModifyExpressionValue(method = "triggerBlackout", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;contains(Lnet/minecraft/state/property/Property;)Z"))
    public boolean submerged$disableMoreBlocksDuringBlackout(boolean original, @Local(name = "state") BlockState state, @Local(name = "pos") BlockPos pos) {
        boolean isOtherLightBlock = false;
        for (Block block : Submerged.BLACKOUT_BLOCKS.keySet()) {
            if (!state.contains(WatheProperties.ACTIVE) && (state.isOf(block) || state.contains(Properties.LIT))) {
                if (state.contains(Properties.LEVEL_15) && state.get(Properties.LEVEL_15) == 0) { //ignore light level 0 blocks, they are used for kill blocks
                    break;
                }
                isOtherLightBlock = true;
                int duration = GameConstants.BLACKOUT_MIN_DURATION + this.world.random.nextInt(GameConstants.BLACKOUT_MAX_DURATION - GameConstants.BLACKOUT_MIN_DURATION);
                if (duration > this.ticks) this.ticks = duration;
                WorldBlackoutComponent.BlackoutDetails detail = new WorldBlackoutComponent.BlackoutDetails(pos, duration, state.contains(Properties.LIT) ? state.get(Properties.LIT) : false);
                detail.init(this.world);
                this.blackouts.add(detail);
                break;
            }
        }
        return original;
    }
}
