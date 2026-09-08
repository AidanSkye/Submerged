package me.aidanskye.submerged.mixin;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.ScoreboardRoleSelectorComponent;
import dev.doctor4t.wathe.command.GameSettingsCommand;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameSettingsCommand.class)
public abstract class GameSettingsCommandMixin {

    //this didn't work for some reason, so I just went ahead and rewrote it
//    @WrapOperation(method = "lambda$register$4", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/cca/ScoreboardRoleSelectorComponent;reset()I"))
//    private static int fixTogglingWeights(ScoreboardRoleSelectorComponent instance, Operation<Integer> original, @Local(argsOnly = true) CommandContext<ServerCommandSource> context) {
//        return ScoreboardRoleSelectorComponent.KEY.get(context.getSource().getServer().getScoreboard()).reset();
//    }

    @Inject(method = "lambda$register$4", at = @At(value = "HEAD"), cancellable = true)
    private static void fixTogglingWeights(CommandContext<ServerCommandSource> context, CallbackInfoReturnable<Integer> cir) {
        GameWorldComponent.KEY.get(context.getSource().getWorld()).setWeightsEnabled(BoolArgumentType.getBool(context, "enabled"));
        ScoreboardRoleSelectorComponent.KEY.get(context.getSource().getServer().getScoreboard()).reset();
        cir.setReturnValue(1);
    }

}
