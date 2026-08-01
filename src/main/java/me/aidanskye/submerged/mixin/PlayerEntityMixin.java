package me.aidanskye.submerged.mixin;

import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.game.GameFunctions;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.game.mapeffect.polus.SubmergedPolusMapEffect;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedYachtMapEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends Entity {
    @Shadow
    protected boolean isSubmergedInWater;

    @Shadow
    public abstract boolean isInCreativeMode();

    @Shadow
    protected abstract void closeHandledScreen();

    @Shadow
    public abstract void sendMessage(Text message, boolean overlay);

    public PlayerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "isSwimming", at = @At("HEAD"), cancellable = true)
    private void submerged$disableSwimmingOnYachtMap(CallbackInfoReturnable<Boolean> ci) {
        GameWorldComponent gameWorldComponent = GameWorldComponent.KEY.get(this.getWorld());
        if (gameWorldComponent.isRunning() && !isInCreativeMode()) {
            ci.setReturnValue(false);
        }
    }

    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void submerged$disableSprintInWater(CallbackInfo ci) {
        GameWorldComponent gameWorldComponent = GameWorldComponent.KEY.get(this.getWorld());
        if (isSprinting() && isTouchingWater() && gameWorldComponent.isRunning() && !isInCreativeMode()) {
            setSprinting(false);
        }
    }

    //TODO: move this to GameWorldComponentMixin
    @Inject(method = "tick", at = @At("HEAD"))
    public void submerged$killInLavaOnSubmerged(CallbackInfo ci) {
        GameWorldComponent gameWorldComponent = GameWorldComponent.KEY.get(this.getWorld());
        if (isInLava() && gameWorldComponent.isRunning() && gameWorldComponent.getMapEffect() instanceof SubmergedPolusMapEffect && GameFunctions.isPlayerAliveAndSurvival((PlayerEntity) (Object) this)) {
            GameFunctions.killPlayer((PlayerEntity) (Object) this, true, ((PlayerEntity) (Object) this).getLastAttacker() instanceof PlayerEntity killerPlayer ? killerPlayer : null, Submerged.SubmergedDeathReasons.FELL_INTO_LAVA);
        }
    }

//    @Inject(method = "openHandledScreen", at = @At("HEAD"))
//    public void submerged$disableOpeningGuisInGame(NamedScreenHandlerFactory factory, CallbackInfoReturnable<OptionalInt> cir) {
//        GameWorldComponent gameWorldComponent = GameWorldComponent.KEY.get(this.getWorld());
//        //if ((!isInCreativeMode()) && gameWorldComponent.isRunning()) {
//        if (!isInCreativeMode()) {
////            cir.cancel();
////            closeHandledScreen();
//            sendMessage(Text.literal("AHHHHHH"), true);
//        }
//        sendMessage(Text.literal("jimmy"), true);
//    }
}
