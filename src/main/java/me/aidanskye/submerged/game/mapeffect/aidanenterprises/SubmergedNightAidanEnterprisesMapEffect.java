package me.aidanskye.submerged.game.mapeffect.aidanenterprises;

import dev.doctor4t.wathe.cca.TrainWorldComponent;
import me.aidanskye.submerged.game.mapeffect.clue.SubmergedClueMapEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.List;

public class SubmergedNightAidanEnterprisesMapEffect extends SubmergedAidanEnterprisesMapEffect {
    public SubmergedNightAidanEnterprisesMapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        super.initializeMapEffects(serverWorld, players);
        serverWorld.setTimeOfDay(18000);
    }
}
