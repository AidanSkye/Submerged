package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.game.GameConstants;
import dev.doctor4t.wathe.game.GameFunctions;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.game.mapeffect.aidanenterprises.SubmergedAidanEnterprisesMapEffect;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedYachtMapEffect;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameWorldComponent.class)
public abstract class GameWorldComponentMixin {

    @Shadow
    public abstract MapEffect getMapEffect();

    @Shadow
    public abstract boolean isRunning();

    @WrapOperation(method = "serverTick", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/game/GameFunctions;killPlayer(Lnet/minecraft/entity/player/PlayerEntity;ZLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Identifier;)V"))
    public void submerged$fallingOffYachtSpawnsBody(PlayerEntity victim, boolean spawnBody, PlayerEntity killer, Identifier deathReason, Operation<Void> original) {
        if (getMapEffect() instanceof SubmergedYachtMapEffect && victim.isSubmergedInWater()) {
            original.call(victim, true, killer, deathReason);
        } else {
            original.call(victim, spawnBody, killer, deathReason);
        }
    }

    @Inject(method = "serverTick", at = @At(value = "TAIL"))
    public void submerged$updateElevatorsThatHaveDefaultSettings(CallbackInfo ci, @Local(name = "serverWorld") ServerWorld serverWorld) {
        if (serverWorld.getTime() % 40 == 0) {
            if (isRunning() && getMapEffect() instanceof SubmergedAidanEnterprisesMapEffect && FabricLoader.getInstance().isModLoaded("movingelevators")) {
                if (SubmergedAidanEnterprisesMapEffect.shouldUpdateElevators(serverWorld)) {
                    SubmergedAidanEnterprisesMapEffect.setElevatorSettings(serverWorld);
                }
            }
        }
    }

    @Inject(method = "serverTick", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/game/GameFunctions;isPlayerAliveAndSurvival(Lnet/minecraft/entity/player/PlayerEntity;)Z", shift = At.Shift.AFTER, ordinal = 2))
    public void submerged$elevatorsKillYou(CallbackInfo ci, @Local(name = "serverWorld") ServerWorld serverWorld, @Local(name = "player") ServerPlayerEntity player) {
        BlockState headState = serverWorld.getBlockState(BlockPos.ofFloored(player.getPos().add(0, 1,0)));
        BlockState bodyState = serverWorld.getBlockState(BlockPos.ofFloored(player.getPos()));
        if (headState.isOf(Blocks.LIGHT) && headState.get(Properties.LEVEL_15) == 0) {
            GameFunctions.killPlayer(player, true, player.getLastAttacker() instanceof PlayerEntity killerPlayer ? killerPlayer : null, Submerged.SubmergedDeathReasons.CRUSHED_BY_ELEVATOR);
        } else if (bodyState.isOf(Blocks.LIGHT) && bodyState.get(Properties.LEVEL_15) == 0) {
            GameFunctions.killPlayer(player, true, player.getLastAttacker() instanceof PlayerEntity killerPlayer ? killerPlayer : null, Submerged.SubmergedDeathReasons.FELL_INTO_ELEVATOR);
        }
    }

}
