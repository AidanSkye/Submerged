package me.aidanskye.submerged.game.mapeffect.clue;

import dev.doctor4t.wathe.cca.TrainWorldComponent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public class SubmergedSundownClueMapEffect extends SubmergedClueMapEffect {
    public SubmergedSundownClueMapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        super.initializeMapEffects(serverWorld, players);
        serverWorld.setTimeOfDay(12800);
    }
}
