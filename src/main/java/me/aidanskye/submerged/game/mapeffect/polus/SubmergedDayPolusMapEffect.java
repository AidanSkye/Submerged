package me.aidanskye.submerged.game.mapeffect.polus;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public class SubmergedDayPolusMapEffect extends SubmergedPolusMapEffect {
    public SubmergedDayPolusMapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        super.initializeMapEffects(serverWorld, players);
        serverWorld.setTimeOfDay(6000);
    }
}
