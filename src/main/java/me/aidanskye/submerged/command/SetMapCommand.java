package me.aidanskye.submerged.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.doctor4t.wathe.Wathe;
import dev.doctor4t.wathe.cca.MapVariablesWorldComponent;
import me.aidanskye.submerged.Submerged;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

//this command isn't needed if you are using gexpress for your maps (you should)
public class SetMapCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("setWatheMap")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(
                                CommandManager.literal(Wathe.id("train").toString())
                                        .executes(context -> setMap(context.getSource(), "train"))
                        ).then(
                                CommandManager.literal(Submerged.id("clue").toString())
                                        .executes(context -> setMap(context.getSource(), "clue"))
                        ).then(
                                CommandManager.literal(Submerged.id("aidan_enterprises").toString())
                                        .executes(context -> setMap(context.getSource(), "aidan_enterprises"))
                        ).then(
                                CommandManager.literal(Submerged.id("yacht").toString())
                                        .executes(context -> setMap(context.getSource(), "yacht"))
                        ).then(
                                CommandManager.literal(Submerged.id("polus").toString())
                                        .executes(context -> setMap(context.getSource(), "polus"))
                        ).then(
                                CommandManager.literal(Submerged.id("mineshaft").toString())
                                        .executes(context -> setMap(context.getSource(), "mineshaft"))
                        ).then(
                                CommandManager.literal(Submerged.id("clover").toString())
                                        .executes(context -> setMap(context.getSource(), "clover"))
                        )
        );
    }

    private static int setMap(ServerCommandSource source, String map) { //254
        MapVariablesWorldComponent WorldVariables = MapVariablesWorldComponent.KEY.get(source.getWorld());
        switch (map) {
            case "train" -> {
                WorldVariables.setSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-872.5f, 0f, -323f), 90f, 0f));
                WorldVariables.setSpectatorSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-68f, 133f, -535.5f), -90f, 15f));

                WorldVariables.setReadyArea(new Box(-1017, -1, -363.75f, -813, 3, -357.25f));
                WorldVariables.setPlayAreaOffset(new Vec3i(963, 121, -175));
                WorldVariables.setPlayArea(new Box(-140, 118, -535.5f - 15, 230, 200, -535.5f + 15));

                WorldVariables.setResetTemplateArea(new Box(-57, 64, -531, 177, 74, -541));
                WorldVariables.setResetPasteOffset(new Vec3i(0, 55, 0));
            }
            case "clue" -> {
                WorldVariables.setSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-794f, 1f, -190.5f), 0f, 0f));
                WorldVariables.setSpectatorSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(60f, 250f, -1431.5f), -90f, 15f));

                WorldVariables.setReadyArea(new Box(-791, 3, -173, -798, 7, -169));
                WorldVariables.setPlayAreaOffset(new Vec3i(854, 237, -1233));
                WorldVariables.setPlayArea(new Box(121, 213, -1481, -10, 286, -1331));

                WorldVariables.setResetTemplateArea(new Box(121, 93, -1481, -10, 166, -1331));
                WorldVariables.setResetPasteOffset(new Vec3i(0, 120, 0));
            }
            case "aidan_enterprises" -> {
                WorldVariables.setSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-875.5f, 0.0625f, -291.5f), 0f, -5f));
                WorldVariables.setSpectatorSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(776.5f, 261f, -1387.5f), 132f, 21f));

                WorldVariables.setReadyArea(new Box(-867, 3, -279, -885, 8, -273));
                WorldVariables.setPlayAreaOffset(new Vec3i(1601, 249, -1148));
                WorldVariables.setPlayArea(new Box(705, 215, -1366, 792, 263, -1444));

                WorldVariables.setResetTemplateArea(new Box(792, 105, -1444, 701, 65, -1365));
                WorldVariables.setResetPasteOffset(new Vec3i(0, 154, 1));
            }
            case "yacht" -> {
                WorldVariables.setSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-875.5f, 0.0625f, -291.5f), 0f, -5f));
                WorldVariables.setSpectatorSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(745.5f, 152.0f, -1940.5f), 140f, 20f));

                WorldVariables.setReadyArea(new Box(-867, 3, -279, -885, 8, -273));
                WorldVariables.setPlayAreaOffset(new Vec3i(1505, 135, -1707));
                WorldVariables.setPlayArea(new Box(564, 102, -2008, 784, 170, -1958));

                WorldVariables.setResetTemplateArea(new Box(564, -19, -2008, 787, 66, -1945));
                WorldVariables.setResetPasteOffset(new Vec3i(0, 113, 0));
            }
            case "polus" -> {
                WorldVariables.setSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-863f, 275f, -314f), 0f, 0f));
                WorldVariables.setSpectatorSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-713f, 180f, -2203f), 0f, 15f));

                WorldVariables.setReadyArea(new Box(-853, 274, -278, -874, 287, -296));
                WorldVariables.setPlayAreaOffset(new Vec3i(150, -3, -1894));
                WorldVariables.setPlayArea(new Box(-646, 251, -2150, -796, 291, -2273));

                WorldVariables.setResetTemplateArea(new Box(-646, 151, -2150, -796, 191, -2273));
                WorldVariables.setResetPasteOffset(new Vec3i(0, 100, 0));
            }
            case "mineshaft" -> {
                WorldVariables.setSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-875.5f, 0.0625f, -291.5f), 0f, -5f));
                WorldVariables.setSpectatorSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-478.5f, 298f, -1147.5f), -120f, 35f));

                WorldVariables.setReadyArea(new Box(-867, 3, -279, -885, 8, -273));
                WorldVariables.setPlayAreaOffset(new Vec3i(0, 0, 0));
                WorldVariables.setPlayArea(new Box(-535, 286, -1185,-447, 309, -1053));

                WorldVariables.setResetTemplateArea(new Box(-535, 179, -1185, -447, 209, -1053));
                WorldVariables.setResetPasteOffset(new Vec3i(0, 100, 0));
            }
            case "clover" -> {
                WorldVariables.setSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-1099.5f, 0.93f, -227.5f), 180f, -3f));
                WorldVariables.setSpectatorSpawnPos(new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(529.5f, 211f, -3421.5f), 180f, 35f));

                WorldVariables.setReadyArea(new Box(-1122, -1, -264, -1078, 24, -221));
                WorldVariables.setPlayAreaOffset(new Vec3i(1628, 93, -3206));
                WorldVariables.setPlayArea(new Box(436, 179, -3492, 616, 225, -3305));

                WorldVariables.setResetTemplateArea(new Box(436, 78, -3492, 616, 125, -3305));
                WorldVariables.setResetPasteOffset(new Vec3i(0, 100, 0));
            }
        }
        return 1;
    }

}
