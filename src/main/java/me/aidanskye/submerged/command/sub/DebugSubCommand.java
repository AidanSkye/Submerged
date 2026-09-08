package me.aidanskye.submerged.command.sub;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.aidanskye.submerged.cca.SubmergedWorldMapComponent;
import me.aidanskye.submerged.command.argument.MapArgumentType;
import me.aidanskye.submerged.maps.SubmergedMap;
import me.aidanskye.submerged.maps.SubmergedMaps;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class DebugSubCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> getTree() {
        return CommandManager.literal("debug")
                .then(CommandManager.literal("mapData")
                        .executes(context -> listMapData(context.getSource(), null))
                        .then(CommandManager.argument("map", MapArgumentType.map())
                                .executes(context -> listMapData(context.getSource(), MapArgumentType.getMapArgument(context, "map")))
                        )
                )
                .then(CommandManager.literal("listMaps")
                        .executes(context -> listMaps(context.getSource()))
                );
    }

    public static int listMaps(ServerCommandSource source) {
        SubmergedMap currentMap = SubmergedWorldMapComponent.KEY.get(source.getWorld()).getMap();
        for (Map.Entry<Identifier, SubmergedMap> entry : SubmergedMaps.MAPS.entrySet()) {
            boolean isCurrentMap = currentMap != null && entry.getValue() == currentMap;
            Text message = isCurrentMap ? Text.literal("[" + entry.getKey().toString() + "]").withColor(Colors.YELLOW)
                    : Text.literal(entry.getKey().toString());
            source.sendMessage(message);
        }
        return 1;
    }

    public static int listMapData(ServerCommandSource source, @Nullable SubmergedMap map) {
        for (Map.Entry<Identifier, SubmergedMap> entry : SubmergedMaps.MAPS.entrySet()) {
            if (map != null && entry.getValue() != map) {
                continue;
            }
            SubmergedMap.Settings settings = entry.getValue().mapSettings();
            source.sendMessage(Text.literal(String.format(
                    """
                    ----- %1$s -----
                    mapEffect = %11$s
                    
                    mapOrigin = %2$s,
                    lobbyOrigin = %3$s,
                    
                    spawnPos = %4$s,
                    specSpawnPos = %5$s,
                    
                    readyArea = %6$s,
                    playAreaOffset = %7$s,
                    playArea = %8$s,
                    
                    templateArea = %9$s,
                    pasteOffset = %10$s
                    """,
                    entry.getKey(),
                    settings.getMapOrigin().toString(),
                    settings.getLobbyOrigin().toString(),
                    settings.getSpawnPos().pos.toString(),
                    settings.getSpectatorSpawnPos().pos.toString(),
                    settings.getReadyArea().toString(),
                    settings.getPlayAreaOffset().toString(),
                    settings.getPlayArea().toString(),
                    settings.getResetTemplateArea().toString(),
                    settings.getResetPasteOffset().toString(),
                    entry.getValue().defaultMapEffect()
            )));
        }
        return 1;
    }
}
