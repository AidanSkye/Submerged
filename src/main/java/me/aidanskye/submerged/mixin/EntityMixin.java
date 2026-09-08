package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.mapselect.role.rat.RatManager;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @ModifyReturnValue(method = "shouldSpawnSprintingParticles", at = @At(value = "RETURN"))
    private boolean submerged$invisibleRolesHaveNoSprintParticles(boolean original) {
        if (!isLoaded("gexpress") || !isLoaded("noellesroles")) return original;

        Entity entity = ((Entity)(Object) this);
        if (!(entity instanceof PlayerEntity player)) return original;

        if (player == null || player.isRemoved() || player.getWorld() == null) return original;

        GameWorldComponent game = GameWorldComponent.KEY.get(player.getWorld());
        if (game == null || !game.isRunning() || game.getGameStatus() != GameWorldComponent.GameStatus.ACTIVE) return original;

        return original && !(player.isInvisible() && RatManager.isRat(player)); //if they're a rat and invisible, never spawn sprint particles
    }

    @Unique
    private boolean isLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }
}
