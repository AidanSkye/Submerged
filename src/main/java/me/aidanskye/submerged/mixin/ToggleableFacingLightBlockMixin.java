package me.aidanskye.submerged.mixin;

import dev.doctor4t.wathe.block.ToggleableFacingLightBlock;
import dev.doctor4t.wathe.cca.WorldBlackoutComponent;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ToggleableFacingLightBlock.class)
public abstract class ToggleableFacingLightBlockMixin {
    @Inject(method = "onUse", at = @At(value = "HEAD"), cancellable = true)
    private static void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (WorldBlackoutComponent.KEY.get(world).isBlackoutActive()) cir.setReturnValue(ActionResult.SUCCESS);
    }
}
