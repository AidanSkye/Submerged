package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.game.GameFunctions;
import dev.mapselect.modifier.NightVisionManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.BsXinQin.kinswathe.KinsWatheRoles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(NightVisionManager.class)
public abstract class GexpressNightVisionManagerMixin {
    @ModifyVariable(method = "tick", at = @At(value = "STORE"), name = "current")
    private static boolean tick(boolean current, ServerWorld world, @Local(name = "player") ServerPlayerEntity player, @Local(name = "activeGame") boolean activeGame) {
        GameWorldComponent game = GameWorldComponent.KEY.getNullable(world);
        return current || (activeGame && GameFunctions.isPlayerAliveAndSurvival(player) && (game != null && game.isRole(player, KinsWatheRoles.ROBOT)));
    }
}
