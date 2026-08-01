package me.aidanskye.submerged.game.mapeffect.mineshaft;

import cat.rezelyn.watheextended.cca.WatheExtendedWorldComponent;
import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.api.WatheMapEffects;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.TrainWorldComponent;
import dev.doctor4t.wathe.game.GameFunctions;
import dev.doctor4t.wathe.index.WatheItems;
import dev.mapselect.preset.map.RoomKeyRange;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public abstract class SubmergedMineshaftMapEffect extends MapEffect {
    public SubmergedMineshaftMapEffect(Identifier identifier) {
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

        serverWorld.setWeather(10000000, 0, false, false);

        // select rooms
        Collections.shuffle(players);
        int roomNumber = 0;
        int roomAmount = 9;
        boolean rtpEnabled = false;

        boolean watheExtendedEnabled = FabricLoader.getInstance().isModLoaded("watheextended");

        if (FabricLoader.getInstance().isModLoaded("gexpress")) {
            roomAmount = RoomKeyRange.forWorld(serverWorld);
        }
        if (FabricLoader.getInstance().isModLoaded("watheextended")) {
            rtpEnabled = WatheExtendedWorldComponent.KEY.get(serverWorld).isRtpEnabled();
        }

        if (!rtpEnabled) {
            GameFunctions.finalizeGame(serverWorld);
            players.forEach(player -> player.sendMessage(Text.literal("RTP isn't enabled dummy").withColor(Color.RED.getRGB())));
            return;
        }

        for (ServerPlayerEntity serverPlayerEntity : players) {
            if (watheExtendedEnabled) {
                serverPlayerEntity.giveItemStack(new ItemStack(Registries.ITEM.get(Identifier.of("watheextended","guidebook"))));
            }

            ItemStack itemStack = new ItemStack(WatheItems.KEY);
            roomNumber = roomNumber % roomAmount + 1;
            int finalRoomNumber = roomNumber;
            itemStack.apply(DataComponentTypes.LORE, LoreComponent.DEFAULT, component -> new LoreComponent(Text.literal("Room " + finalRoomNumber).getWithStyle(Style.EMPTY.withItalic(false).withColor(0xFF8C00))));
            serverPlayerEntity.giveItemStack(itemStack);
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
