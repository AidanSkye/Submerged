package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.brigadier.context.CommandContext;
import dev.doctor4t.wathe.cca.ScoreboardRoleSelectorComponent;
import dev.doctor4t.wathe.command.GameSettingsCommand;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameSettingsCommand.class)
public abstract class GameSettingsCommandMixin {

    @WrapOperation(method = "lambda$register$4", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/cca/ScoreboardRoleSelectorComponent;reset()I"))
    private static int fixTogglingWeights(ScoreboardRoleSelectorComponent instance, Operation<Integer> original, @Local(argsOnly = true) CommandContext<ServerCommandSource> context) {
        return ScoreboardRoleSelectorComponent.KEY.get(context.getSource().getServer().getScoreboard()).reset();
    }

}
