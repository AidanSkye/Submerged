package me.aidanskye.submerged.game.task;

import dev.doctor4t.wathe.api.WatheRoles;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.PlayerMoodComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public class JobTask implements PlayerMoodComponent.TrainTask, ConditionalTask {
    public boolean fulfilled = false;

    @Override
    public boolean isFulfilled(PlayerEntity player) {
        return this.fulfilled;
    }

    @Override
    public String getName() {
        return "job";
    }

    @Override
    public PlayerMoodComponent.Task getType() {
        return PlayerMoodComponent.Task.valueOf("SUBMERGED_JOB");
    }

    @Override
    public NbtCompound toNbt() {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("type", PlayerMoodComponent.Task.valueOf("SUBMERGED_JOB").ordinal());
        return nbt;
    }

    @Override
    public boolean canBeGenerated(PlayerEntity player) {
        return false;
    }
}
