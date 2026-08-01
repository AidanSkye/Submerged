package me.aidanskye.submerged.mixin;

import dev.doctor4t.wathe.game.mapeffect.HarpyExpressLobbyMapEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(HarpyExpressLobbyMapEffect.class)
public abstract class LobbyMapEffectMixin {

    @Inject(method = "initializeMapEffects", at = @At(value = "TAIL"))
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players, CallbackInfo ci) {
        serverWorld.setTimeOfDay(6000);
    }

}
