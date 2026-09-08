package me.aidanskye.submerged.game.mapeffect.s23;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public class SubmergedNightSierpinski23MapEffect extends SubmergedSierpinski23MapEffect {
    public SubmergedNightSierpinski23MapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        super.initializeMapEffects(serverWorld, players);
        serverWorld.setTimeOfDay(18000);
    }
}
