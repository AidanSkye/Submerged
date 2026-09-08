package me.aidanskye.submerged.game.task;

import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.PlayerMoodComponent;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedYachtMapEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SwimTask implements PlayerMoodComponent.TrainTask, ConditionalTask, MapDependentTask {
    private int timer;

    @Override
    public List<Class<? extends MapEffect>> getWhitelistedMaps() {
        return List.of(SubmergedYachtMapEffect.class);
    }

    public SwimTask(int time) {
        this.timer = time;
    }

    @Override
    public void tick(@NotNull PlayerEntity player) {
        if (player.isTouchingWater() && this.timer > 0) this.timer--;
    }

    @Override
    public boolean isFulfilled(PlayerEntity player) {
        return this.timer <= 0;
    }

    @Override
    public String getName() {
        return "swim";
    }

    @Override
    public PlayerMoodComponent.Task getType() {
        return PlayerMoodComponent.Task.valueOf("SUBMERGED_SWIM");
    }

    @Override
    public NbtCompound toNbt() {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("type", PlayerMoodComponent.Task.valueOf("SUBMERGED_SWIM").ordinal());
        nbt.putInt("timer", this.timer);
        return nbt;
    }

    @Override
    public boolean canBeGenerated(PlayerEntity player) {
        return isMapWhitelisted(GameWorldComponent.KEY.get(player.getWorld()).getMapEffect());
    }
}
