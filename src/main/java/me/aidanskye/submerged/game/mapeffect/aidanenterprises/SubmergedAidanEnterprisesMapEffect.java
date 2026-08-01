package me.aidanskye.submerged.game.mapeffect.aidanenterprises;

import com.supermartijn642.movingelevators.elevator.ElevatorGroup;
import com.supermartijn642.movingelevators.elevator.ElevatorGroupCapability;
import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.api.WatheMapEffects;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.TrainWorldComponent;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;

public abstract class SubmergedAidanEnterprisesMapEffect extends MapEffect {
    public SubmergedAidanEnterprisesMapEffect(Identifier identifier) {
        super(identifier);
    }

    public static List<List<Integer>> elevators = List.of(
            List.of(758, -1406),
            List.of(738, -1406)
    );

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

    public static void setElevatorSettings(ServerWorld serverWorld) {
        for (List<Integer> pos : elevators) {
            ElevatorGroup elevator = ElevatorGroupCapability.get(serverWorld).get(pos.get(0), pos.get(1), Direction.WEST);
            if (elevator == null) {
                return;
            }
            elevator.increaseCageWidth();
            elevator.increaseCageWidth();
            elevator.increaseCageDepth();
            elevator.increaseCageHeight();
            elevator.increaseCageHeight();
            elevator.decreaseCageHeightOffset();
            elevator.decreaseCageHeightOffset();
            elevator.decreaseCageHeightOffset();
        }
        serverWorld.getServer().sendMessage(Text.literal("Successfully Updated Elevators"));
    }

    public static boolean shouldUpdateElevators(ServerWorld serverWorld) {
        for (List<Integer> pos : elevators) {
            ElevatorGroup elevator = ElevatorGroupCapability.get(serverWorld).get(pos.get(0), pos.get(1), Direction.WEST);
            if (elevator == null) {
                return false;
            }
        }
        return ElevatorGroupCapability.get(serverWorld).get(elevators.getFirst().get(0), elevators.getFirst().get(1), Direction.WEST).getCageWidth() == 3;
    }
}
