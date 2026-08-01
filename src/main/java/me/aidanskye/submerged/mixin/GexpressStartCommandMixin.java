package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.doctor4t.wathe.api.GameMode;
import dev.doctor4t.wathe.api.MapEffect;
import dev.mapselect.command.game.StartCommand;
import me.aidanskye.submerged.game.mapeffect.SubmergedMapEffects;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Supplier;

@Mixin(StartCommand.class)
public abstract class GexpressStartCommandMixin {

    @Shadow
    private static LiteralArgumentBuilder<ServerCommandSource> effect(String literal, Supplier<GameMode> mode, Supplier<MapEffect> effect) {
        return null;
    }

    @ModifyReturnValue(method = "mode", at = @At("RETURN"))
    private static LiteralArgumentBuilder<ServerCommandSource> submerged$addMapEffectsToGexpress(LiteralArgumentBuilder<ServerCommandSource> original, @Local(argsOnly = true, name = "mode") java.util.function.Supplier<GameMode> mode) {
        return original
                .then(effect("office", mode, () -> SubmergedMapEffects.SUBMERGED_AIDAN_ENTERPRISES_NIGHT))
                .then(effect("clue", mode, () -> SubmergedMapEffects.SUBMERGED_CLUE_NIGHT))
                .then(effect("polus", mode, () -> SubmergedMapEffects.SUBMERGED_POLUS_NIGHT))
                .then(effect("yacht", mode, () -> SubmergedMapEffects.SUBMERGED_YACHT_NIGHT))
                .then(effect("mineshaft", mode, () -> SubmergedMapEffects.SUBMERGED_MINESHAFT_NIGHT))
                .then(effect("clover", mode, () -> SubmergedMapEffects.SUBMERGED_CLOVER_NIGHT));
    }
}
