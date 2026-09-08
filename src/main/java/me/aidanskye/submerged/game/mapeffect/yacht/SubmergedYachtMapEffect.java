package me.aidanskye.submerged.game.mapeffect.yacht;

import cat.rezelyn.watheextended.cca.WatheExtendedWorldComponent;
import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.api.WatheMapEffects;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.TrainWorldComponent;
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

import java.util.Collections;
import java.util.List;

public abstract class SubmergedYachtMapEffect extends MapEffect {
    public SubmergedYachtMapEffect(Identifier identifier) {
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
        boolean otherHelipad = false;
        int roomAmount = 6;
        boolean rtpEnabled = false;

        boolean watheExtendedEnabled = FabricLoader.getInstance().isModLoaded("watheextended");

        if (FabricLoader.getInstance().isModLoaded("watheextended")) {
            rtpEnabled = WatheExtendedWorldComponent.KEY.get(serverWorld).isRtpEnabled();
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

            //teleport half of the players to other helipad, as long as rtp isn't enabled in WatheExtended
            if (otherHelipad && !rtpEnabled) {
                otherHelipad = false;
                double x = serverPlayerEntity.getX();
                double y = serverPlayerEntity.getY();
                double z = serverPlayerEntity.getZ();
                float pitch = serverPlayerEntity.getPitch();
                float yaw = serverPlayerEntity.getYaw();
                serverPlayerEntity.teleport(serverWorld, x+119, y-10, z, pitch, yaw); //119 -10 0
            } else {
                otherHelipad = true;
            }
        }

        serverWorld.setWeather(0, 10000000, true, true);
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
