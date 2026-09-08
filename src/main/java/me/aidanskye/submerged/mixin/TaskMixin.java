package me.aidanskye.submerged.mixin;

import dev.doctor4t.wathe.cca.PlayerMoodComponent;
import me.aidanskye.submerged.game.task.JobTask;
import me.aidanskye.submerged.game.task.ShowerTask;
import me.aidanskye.submerged.game.task.SwimTask;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Function;

import static dev.doctor4t.wathe.game.GameConstants.getInTicks;

@Mixin(PlayerMoodComponent.Task.class)
public enum TaskMixin {
    SUBMERGED_JOB(nbt -> new JobTask()),
    SUBMERGED_SWIM(nbt -> new SwimTask(getInTicks(0, 15))),
    SUBMERGED_SHOWER(nbt -> new ShowerTask(getInTicks(0, 30)));

    @Shadow
    TaskMixin(@NotNull Function<NbtCompound, PlayerMoodComponent.TrainTask> function) {
    }
}
