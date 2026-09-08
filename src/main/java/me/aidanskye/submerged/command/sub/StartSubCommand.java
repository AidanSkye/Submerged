package me.aidanskye.submerged.command.sub;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.doctor4t.wathe.api.GameMode;
import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.command.argument.GameModeArgumentType;
import dev.doctor4t.wathe.command.argument.MapEffectArgumentType;
import dev.doctor4t.wathe.game.GameConstants;
import dev.doctor4t.wathe.game.GameFunctions;
import me.aidanskye.submerged.cca.SubmergedWorldMapComponent;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class StartSubCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> getTree() {
        return CommandManager.literal("start")
                .then(CommandManager.argument("gameMode", GameModeArgumentType.gameMode())
                        .then(CommandManager.argument("mapEffect", MapEffectArgumentType.mapEffect())
                                .executes(context -> startGame(
                                        context.getSource(),
                                        GameModeArgumentType.getGameModeArgument(context, "gameMode"),
                                        MapEffectArgumentType.getMapEffectArgument(context, "mapEffect")
                                ))
                        )
                        .executes(context -> startGame(
                                        context.getSource(),
                                        GameModeArgumentType.getGameModeArgument(context, "gameMode"),
                                        SubmergedWorldMapComponent.KEY.get(context.getSource().getWorld()).getMap().defaultMapEffect()
                                )
                        )
                );
    }

    private static int startGame(ServerCommandSource source, GameMode gameMode, @Nullable MapEffect mapEffect) {
        if (mapEffect == null) {
            source.sendError(Text.literal("No map effect was specified! Please either select a map or specify a map effect!"));
            return -1;
        }

        if (GameWorldComponent.KEY.get(source.getWorld()).isRunning()) {
            source.sendError(Text.translatable("game.start_error.game_running"));
            return -1;
        }
        GameFunctions.startGame(source.getWorld(), gameMode, mapEffect, GameConstants.getInTicks(gameMode.defaultStartTime, 0));

        return 1;
    }
}
