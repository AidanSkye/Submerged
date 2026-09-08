package me.aidanskye.submerged.command.sub;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.doctor4t.wathe.game.GameFunctions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class StopSubCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> getTree() {
        return CommandManager.literal("stop")
                .then(CommandManager.literal("force").executes(context -> {
                            GameFunctions.finalizeGame(context.getSource().getWorld());
                            return 1;
                        }
                ))
                .executes(context -> {
                    GameFunctions.stopGame(context.getSource().getWorld());
                    return 1;
                }
        );
    }
}
