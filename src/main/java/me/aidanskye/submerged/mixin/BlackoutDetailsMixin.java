package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.doctor4t.wathe.cca.WorldBlackoutComponent;
import dev.doctor4t.wathe.index.WatheProperties;
import dev.doctor4t.wathe.index.WatheSounds;
import me.aidanskye.submerged.Submerged;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldBlackoutComponent.BlackoutDetails.class)
public abstract class BlackoutDetailsMixin {

    @Mutable
    @Final
    @Shadow
    private final BlockPos pos;
    @Mutable
    @Final
    @Shadow
    private final boolean original;

    protected BlackoutDetailsMixin(BlockPos pos, boolean original) {
        this.pos = pos;
        this.original = original;
    }

    @Inject(method = "init", at = @At(value = "RETURN"))
    public void submerged$init(World world, CallbackInfo ci, @Local(name = "state") BlockState state) {
        if (!isBlackoutBlock(state)) return;
        world.setBlockState(this.pos, state.with(Properties.LIT, false));
        world.playSound(null, this.pos, WatheSounds.BLOCK_LIGHT_TOGGLE, SoundCategory.BLOCKS, 0.5f, 1f);
    }

    @Inject(method = "end", at = @At(value = "RETURN"))
    public void submerged$end(World world, CallbackInfo ci, @Local(name = "state") BlockState state) {
        if (!isBlackoutBlock(state)) return;
        world.setBlockState(this.pos, state.with(Properties.LIT, this.original));
        world.playSound(null, this.pos, WatheSounds.BLOCK_LIGHT_TOGGLE, SoundCategory.BLOCKS, 0.5f, 0.5f);
    }

    @ModifyExpressionValue(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;contains(Lnet/minecraft/state/property/Property;)Z"))
    public boolean submerged$tick(boolean original, @Local(name = "state") BlockState state, @Local(argsOnly = true, name = "world") World world) {
        return original && !isBlackoutBlock(state);
    }

    @Unique
    private boolean isBlackoutBlock(BlockState state) {
        for (Block block : Submerged.BLACKOUT_BLOCKS) {
            if (state.isOf(block) || state.contains(Properties.LIT)) {
                return true;
            }
        }
        return false;
    }

}
