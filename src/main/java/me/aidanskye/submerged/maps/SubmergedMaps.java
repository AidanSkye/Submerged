package me.aidanskye.submerged.maps;

import com.google.gson.*;
import dev.doctor4t.wathe.Wathe;
import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.api.WatheMapEffects;
import dev.doctor4t.wathe.cca.MapVariablesWorldComponent;
import me.aidanskye.submerged.Submerged;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmergedMaps {
    public static final HashMap<Identifier, SubmergedMap> MAPS = new HashMap<>();
    private static final HashMap<Identifier, SubmergedMap> PERSISTENT_MAPS = new HashMap<>();
    private static final File MAPS_FOLDER = FabricLoader.getInstance().getConfigDir().resolve("submerged").resolve("maps").toFile();

    public static SubmergedMap HARPY_EXPRESS = registerPersistentMap(Wathe.id("harpy_express"), new SubmergedMap(
            new SubmergedMap.Settings(
                    null,
                    null,
                    new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-872.5f, 0f, -323f), 90f, 0f),
                    new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-68f, 133f, -535.5f), -90f, 15f),

                    new Box(-1017, -1, -363.75f, -813, 3, -357.25f),
                    new Vec3i(963, 121, -175),
                    new Box(-140, 118, -535.5f - 15, 230, 200, -535.5f + 15),

                    new Box(-57, 64, -531, 177, 74, -541),
                    new Vec3i(0, 55, 0),
                    new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(-999.5F, 1.0F, -360.5F), -90.0F, 0.0F)
            ), WatheMapEffects.HARPY_EXPRESS_NIGHT, new ArrayList<>(), false
    ));

    public static void loadMaps() {
        try {
            if (!MAPS_FOLDER.exists()) {
                MAPS_FOLDER.mkdirs();
                return;
            }
            MAPS.clear();
            registerPersistentMaps();

            int maps = 0;
            for (File file : MAPS_FOLDER.listFiles()) {
                if (!file.isFile()) continue;
                if (file.getName().startsWith("-")) continue;
                Identifier mapId = Submerged.id(file.getName().substring(0, file.getName().lastIndexOf(".")));
                try (FileReader reader = new FileReader(file)) {
                    JsonElement element = JsonParser.parseReader(reader);
                    if (!element.isJsonObject()) {
                        Submerged.LOGGER.error("There was an error when loading map {}!", file.getName());
                        continue;
                    }
                    JsonObject json = element.getAsJsonObject();

                    Identifier mapEffectId = json.get("defaultMapEffect") == null ? null : Identifier.of(json.get("defaultMapEffect").getAsString());
                    MapEffect defaultMapEffect = WatheMapEffects.MAP_EFFECTS.get(mapEffectId);
                    if (defaultMapEffect == null) {
                        Submerged.LOGGER.error("There was an error when loading map {}! No default map effect!", file.getName());
                        continue;
                    }

                    SubmergedMap.Settings settings = new SubmergedMap.Settings();

                    boolean isRelative = true; //whether the provided map values should be offset by the mapOrigin and lobbyOrigin points
                    if (json.get("isRelative") != null && json.get("isRelative").isJsonPrimitive()) {
                        if (json.getAsJsonPrimitive().isBoolean()) isRelative = json.getAsBoolean();
                    }

                    if (isRelative) {
                        settings.setMapOrigin(getAsVector(json.get("mapOrigin")));
                        settings.setLobbyOrigin(getAsVector(json.get("lobbyOrigin")));
                    } else {
                        settings.setMapOrigin(Vec3i.ZERO);
                        settings.setLobbyOrigin(Vec3i.ZERO);
                    }

                    settings.setSpawnPos(getAsPosWithOrientation(json.get("spawnPos")));
                    settings.setSpectatorSpawnPos(getAsPosWithOrientation(json.get("spectatorSpawnPos")));

                    settings.setReadyArea(getAsBox(json.get("readyArea")));
                    settings.setPlayAreaOffset(getAsVector(json.get("playAreaOffset")));
                    settings.setPlayArea(getAsBox(json.get("playArea")));

                    settings.setResetTemplateArea(getAsBox(json.get("resetTemplateArea")));
                    settings.setResetPasteOffset(getAsVector(json.get("resetPasteOffset")));

                    if (json.has("readyAreaSpawnPos")) {
                        settings.setReadyAreaSpawnPos(getAsPosWithOrientation(json.get("readyAreaSpawnPos")));
                    } else {
                        settings.setReadyAreaSpawnPos(settings.getSpawnPos());
                    }

                    if (!settings.isValid()) {
                        Submerged.LOGGER.error("There was an error when loading map {}! Invalid map settings!", file.getName());
                        continue;
                    }

                    List<Box> freshAirAreas = new ArrayList<>();
                    if (json.has("freshAirAreas") && json.get("freshAirAreas").isJsonArray()) {
                        JsonArray array = json.get("freshAirAreas").getAsJsonArray();
                        for (JsonElement arrayElement : array.asList()) {
                            Box box = getAsBox(arrayElement);

                            if (isRelative) {
                                if (box != null) freshAirAreas.add(SubmergedMap.Settings.offsetBox(box, settings.getMapOrigin()));
                            } else {
                                if (box != null) freshAirAreas.add(box);
                            }
                        }
                    }

                    SubmergedMap map = new SubmergedMap(isRelative ? settings.offsetValues() : settings, defaultMapEffect, freshAirAreas, isRelative);
                    registerMap(mapId, map);
                    Submerged.LOGGER.info("Successfully loaded map {}!", mapId);
                }
                maps++;
            }
            Submerged.LOGGER.info("Successfully loaded {} maps!", maps);
        } catch (Exception e) {
            Submerged.LOGGER.error("There was an error loading maps!");
            Submerged.LOGGER.error(e.toString());
        }
    }

    @Nullable
    public static Vec3i getAsVector(JsonElement element) {
        if (!element.isJsonArray()) return null;
        JsonArray array = element.getAsJsonArray();

        if (array.size() != 3) return null;

        int x = 0;
        int[] points = new int[3];
        for (JsonElement arrayElement : array.asList()) {
            if (!arrayElement.isJsonPrimitive()) return null;
            JsonPrimitive primitive = arrayElement.getAsJsonPrimitive();
            if (!primitive.isNumber()) return null;
            points[x++] = primitive.getAsInt();
        }
        return new Vec3i(points[0], points[1], points[2]);
    }

    @Nullable
    public static Box getAsBox(JsonElement element) {
        if (!element.isJsonArray()) return null;
        JsonArray array = element.getAsJsonArray();

        if (array.size() != 6) return null;

        int x = 0;
        double[] points = new double[6];
        for (JsonElement arrayElement : array.asList()) {
            if (!arrayElement.isJsonPrimitive()) return null;
            JsonPrimitive primitive = arrayElement.getAsJsonPrimitive();
            if (!primitive.isNumber()) return null;
            points[x++] = primitive.getAsDouble();
        }
        return new Box(points[0], points[1], points[2], points[3], points[4], points[5]);
    }

    @Nullable
    public static MapVariablesWorldComponent.PosWithOrientation getAsPosWithOrientation(JsonElement element) {
        if (!element.isJsonArray()) return null;
        JsonArray array = element.getAsJsonArray();

        if (array.size() != 5) return null;

        int x = 0;
        double[] points = new double[3];
        Float yaw = null;
        Float pitch = null;
        for (JsonElement arrayElement : array.asList()) {
            if (!arrayElement.isJsonPrimitive()) return null;
            JsonPrimitive primitive = arrayElement.getAsJsonPrimitive();
            if (!primitive.isNumber()) return null;
            if (x<3) {
                points[x++] = primitive.getAsDouble();
            } else if (x == 3) {
                yaw = primitive.getAsFloat();
                x++;
            } else {
                pitch = primitive.getAsFloat();
                x++;
            }
        }
        if (yaw == null || pitch == null) return null;
        return new MapVariablesWorldComponent.PosWithOrientation(new Vec3d(points[0], points[1], points[2]), yaw, pitch);
    }

    public static SubmergedMap registerMap(Identifier identifier, SubmergedMap map) {
        if (MAPS.containsKey(identifier)) return MAPS.get(identifier);
        MAPS.put(identifier, map);
        return map;
    }

    /**
     * Register a map that doesn't get cleared whenever {@link #loadMaps()} is run.
     */
    public static SubmergedMap registerPersistentMap(Identifier identifier, SubmergedMap map) {
        if (PERSISTENT_MAPS.containsKey(identifier)) return PERSISTENT_MAPS.get(identifier);
        PERSISTENT_MAPS.put(identifier, map);
        return map;
    }

    private static void registerPersistentMaps() {
        for (Map.Entry<Identifier, SubmergedMap> persistentMap : PERSISTENT_MAPS.entrySet()) {
            registerMap(persistentMap.getKey(), persistentMap.getValue());
        }
    }
}
