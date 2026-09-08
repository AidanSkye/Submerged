package me.aidanskye.submerged.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import me.aidanskye.submerged.command.sub.DebugSubCommand;
import me.aidanskye.submerged.command.sub.SetMapSubCommand;
import me.aidanskye.submerged.command.sub.StartSubCommand;
import me.aidanskye.submerged.command.sub.StopSubCommand;
import me.aidanskye.submerged.maps.SubmergedMaps;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class SubmergedCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(root("submerged"));
        dispatcher.register(root("sub"));
        dispatcher.register(root("s"));
    }

    public static LiteralArgumentBuilder<ServerCommandSource> root(String name) {
        return CommandManager.literal(name)
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("reloadMaps")
                        .executes(SubmergedCommand::reloadMaps)
                )
                .then(SetMapSubCommand.getTree())
                .then(StartSubCommand.getTree())
                .then(StopSubCommand.getTree())
                .then(DebugSubCommand.getTree());
    }

    public static int reloadMaps(CommandContext<ServerCommandSource> context) {
        SubmergedMaps.loadMaps();
        return 1;
    }
}
