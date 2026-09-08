package me.aidanskye.submerged.game.task;

import dev.doctor4t.wathe.api.MapEffect;
import net.minecraft.entity.player.PlayerEntity;

import java.util.List;

public interface ConditionalTask {
    boolean canBeGenerated(PlayerEntity player);
}
