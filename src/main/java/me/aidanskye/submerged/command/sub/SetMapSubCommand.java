package me.aidanskye.submerged.command.sub;

import cat.rezelyn.watheextended.cca.WatheExtendedWorldComponent;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.doctor4t.wathe.api.GameMode;
import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.MapVariablesWorldComponent;
import dev.doctor4t.wathe.command.argument.GameModeArgumentType;
import dev.doctor4t.wathe.command.argument.MapEffectArgumentType;
import dev.doctor4t.wathe.game.GameConstants;
import dev.doctor4t.wathe.game.GameFunctions;
import me.aidanskye.submerged.cca.SubmergedWorldMapComponent;
import me.aidanskye.submerged.command.argument.MapArgumentType;
import me.aidanskye.submerged.maps.SubmergedMap;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class SetMapSubCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> getTree() {
        return CommandManager.literal("setMap")
                .then(CommandManager.argument("map", MapArgumentType.map())
                        .executes(context -> setMap(context.getSource(), MapArgumentType.getMapArgument(context, "map")))
                );
    }

    public static int setMap(ServerCommandSource source, SubmergedMap map) {
        MapVariablesWorldComponent WorldVariables = MapVariablesWorldComponent.KEY.get(source.getWorld());
        SubmergedMap.Settings settings = map.mapSettings();

        WorldVariables.setSpawnPos(settings.getSpawnPos());
        WorldVariables.setSpectatorSpawnPos(settings.getSpectatorSpawnPos());

        WorldVariables.setReadyArea(settings.getReadyArea());
        WorldVariables.setPlayAreaOffset(settings.getPlayAreaOffset());
        WorldVariables.setPlayArea(settings.getPlayArea());

        WorldVariables.setResetTemplateArea(settings.getResetTemplateArea());
        WorldVariables.setResetPasteOffset(settings.getResetPasteOffset());

        if (FabricLoader.getInstance().isModLoaded("watheextended")) {
            WatheExtendedWorldComponent.KEY.get(source.getWorld()).setReadyAreaSpawnPos(settings.getReadyAreaSpawnPos());
        }

        SubmergedWorldMapComponent.KEY.get(source.getWorld()).setMap(map);

        source.sendMessage(Text.literal("Successfully set the map!"));
        return 1;
    }
}
