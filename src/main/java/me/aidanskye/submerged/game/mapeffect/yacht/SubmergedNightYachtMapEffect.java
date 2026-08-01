package me.aidanskye.submerged.game.mapeffect.yacht;

import me.aidanskye.submerged.game.mapeffect.clue.SubmergedClueMapEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public class SubmergedNightYachtMapEffect extends SubmergedYachtMapEffect {
    public SubmergedNightYachtMapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        super.initializeMapEffects(serverWorld, players);
        serverWorld.setTimeOfDay(18000);
    }
}
