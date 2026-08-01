package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.entity.PlayerBodyEntity;
import dev.doctor4t.wathe.game.GameConstants;
import dev.doctor4t.wathe.game.GameFunctions;
import me.aidanskye.submerged.game.mapeffect.aidanenterprises.SubmergedAidanEnterprisesMapEffect;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedYachtMapEffect;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameFunctions.class)
public abstract class GameFunctionsMixin {

    @WrapOperation(method = "killPlayer(Lnet/minecraft/entity/player/PlayerEntity;ZLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Identifier;)V", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/entity/PlayerBodyEntity;refreshPositionAndAngles(DDDFF)V"))
    private static void submerged$spawnBodyAtWaterLevelOnYacht(PlayerBodyEntity instance, double x, double y, double z, float yaw, float pitch, Operation<Void> original, PlayerEntity victim, boolean spawnBody, @Nullable PlayerEntity killer, Identifier deathReason) {
        GameWorldComponent gameWorldComponent = GameWorldComponent.KEY.get(victim.getWorld());
        if (gameWorldComponent.getMapEffect() instanceof SubmergedYachtMapEffect && victim.isSubmergedInWater()) {
            World world = victim.getWorld();
            int xPos = (int) x;
            int yPos = (int) y;
            int zPos = (int) z;
            if (world.getBlockState(new BlockPos(xPos, yPos, zPos)).isOf(Blocks.WATER)) {
                while (world.getBlockState(new BlockPos(xPos, yPos, zPos)).isOf(Blocks.WATER)) {
                    yPos++;
                }
                instance.setNoGravity(true);
                original.call(instance, x, (double) yPos-0.25, z, yaw, pitch);
                return;
            }
        }
        original.call(instance, x, y, z, yaw, pitch);
    }

    @Inject(method = "finalizeGame", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/api/GameMode;finalizeGame(Lnet/minecraft/server/world/ServerWorld;Ldev/doctor4t/wathe/cca/GameWorldComponent;)V", shift = At.Shift.AFTER))
    private static void submerged$addUnusedFinalizeMapEffects(ServerWorld world, CallbackInfo ci, @Local(name = "gameComponent") GameWorldComponent gameComponent) {
        gameComponent.getMapEffect().finalizeMapEffects(world, world.getPlayers());
    }

}
