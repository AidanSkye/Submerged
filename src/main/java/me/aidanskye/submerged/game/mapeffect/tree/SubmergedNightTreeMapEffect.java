package me.aidanskye.submerged.game.mapeffect.tree;

import me.aidanskye.submerged.game.mapeffect.clover.SubmergedCloverMapEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public class SubmergedNightTreeMapEffect extends SubmergedTreeMapEffect {
    public SubmergedNightTreeMapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        super.initializeMapEffects(serverWorld, players);
        serverWorld.setTimeOfDay(18000);
    }
}
