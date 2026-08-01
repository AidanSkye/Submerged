package me.aidanskye.submerged.game.mapeffect.polus;

import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.api.WatheMapEffects;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.TrainWorldComponent;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public abstract class SubmergedPolusMapEffect extends MapEffect {
    public SubmergedPolusMapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        TrainWorldComponent trainWorldComponent = TrainWorldComponent.KEY.get(serverWorld);
        trainWorldComponent.setSnow(false);
        trainWorldComponent.setFog(true);
        trainWorldComponent.setHud(true);
        trainWorldComponent.setSpeed(0);
        trainWorldComponent.setTime(0);

        boolean watheExtendedEnabled = FabricLoader.getInstance().isModLoaded("watheextended");

        for (ServerPlayerEntity serverPlayerEntity : players) {
            if (watheExtendedEnabled) {
                serverPlayerEntity.giveItemStack(new ItemStack(Registries.ITEM.get(Identifier.of("watheextended","guidebook"))));
            }
        }

        if (!FabricLoader.getInstance().isModLoaded("gexpress")) { //use gexpress weather if it is enabled
            serverWorld.setWeather(0, 10000000, true, false);
        }
    }

    @Override
    public void finalizeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        serverWorld.setWeather(1000000, 0, false, false);
        // switch back to the lobby map effects
        GameWorldComponent gameWorldComponent = GameWorldComponent.KEY.get(serverWorld);
        gameWorldComponent.setMapEffect(WatheMapEffects.HARPY_EXPRESS_LOBBY);
        gameWorldComponent.getMapEffect().initializeMapEffects(serverWorld, players);
    }
}
