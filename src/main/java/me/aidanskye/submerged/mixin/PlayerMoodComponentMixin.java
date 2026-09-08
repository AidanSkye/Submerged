package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.doctor4t.wathe.cca.PlayerMoodComponent;
import dev.doctor4t.wathe.game.GameConstants;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.game.modifier.SubmergedModifiers;
import me.aidanskye.submerged.game.task.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.agmas.harpymodloader.component.WorldModifierComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

import static dev.doctor4t.wathe.game.GameConstants.getInTicks;

@Mixin(PlayerMoodComponent.class)
public class PlayerMoodComponentMixin implements TaskFulfillmentMethods {

    @Shadow
    @Final
    public Map<PlayerMoodComponent.Task, PlayerMoodComponent.TrainTask> tasks;

    @Shadow
    @Final
    private PlayerEntity player;

    //this injection point is hell :sob:
    //someone please send help
    //alright, I know this mixin kinda sucks, but it works and that's all I wanted, I've already spent like 5 hours on this one fucking mixin
    @Inject(method = "generateTask", at = @At(value = "INVOKE", target = "Ljava/util/Map$Entry;getValue()Ljava/lang/Object;", shift = At.Shift.AFTER), cancellable = true)
    private void submerged$replaceTaskSwitchStatement(CallbackInfoReturnable<PlayerMoodComponent.TrainTask> cir, @Local(name = "random") float random, @Local(name = "entry") Map.Entry<PlayerMoodComponent.Task, Float> entry, @Local(name = "total") float total) {
        Submerged.LOGGER.info("{} - {}: {} - {} // total={}", this.player.getName().getString(), entry.getKey().toString(), random, entry.getValue(), total);
        if ((random - entry.getValue()) <= 0) { //shouldn't be necessary, but it is for some reason idk I'm gonna kms
            Submerged.LOGGER.info("{} - RETURNING TASK: {}", this.player.getName().getString(), entry.getKey().toString());
            cir.setReturnValue(switch (entry.getKey().ordinal()) {
                case 0 -> new PlayerMoodComponent.SleepTask(GameConstants.SLEEP_TASK_DURATION);
                case 1 -> new PlayerMoodComponent.OutsideTask(GameConstants.OUTSIDE_TASK_DURATION);
                case 2 -> new PlayerMoodComponent.EatTask();
                case 3 -> new PlayerMoodComponent.DrinkTask();
                case 4 -> new JobTask();
                case 5 -> new SwimTask(getInTicks(0, 15));
                case 6 -> new ShowerTask(getInTicks(0, 30));
                default -> {
                    Submerged.LOGGER.error("task switch hit default case, this is bad");
                    yield null;
                }
            });
        }
    }

    @WrapOperation(method = "generateTask", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/cca/PlayerMoodComponent$Task;values()[Ldev/doctor4t/wathe/cca/PlayerMoodComponent$Task;"))
    private PlayerMoodComponent.Task[] submerged$onlyGenerateTasksThatCanBeGenerated(Operation<PlayerMoodComponent.Task[]> original) {
        PlayerMoodComponent.Task[] unfilteredTasks = original.call();

        int n = 0;

        for (PlayerMoodComponent.Task task : unfilteredTasks) {
            PlayerMoodComponent.TrainTask trainTask = ((PlayerMoodComponent.Task) task).setFunction.apply(new NbtCompound());
            if (!(trainTask instanceof ConditionalTask) || ((ConditionalTask) trainTask).canBeGenerated(this.player)) n++;
        }

        PlayerMoodComponent.Task[] tasks = new PlayerMoodComponent.Task[n];

        n = 0;
        for (PlayerMoodComponent.Task task : unfilteredTasks) {
            PlayerMoodComponent.TrainTask trainTask = ((PlayerMoodComponent.Task) task).setFunction.apply(new NbtCompound());
            if (!(trainTask instanceof ConditionalTask) || ((ConditionalTask) trainTask).canBeGenerated(this.player)) tasks[n++] = task;
        }

        return tasks;
    }

    @Override
    public void getAJob() {
        if (this.tasks.get(PlayerMoodComponent.Task.valueOf("SUBMERGED_JOB")) instanceof JobTask jobTask) jobTask.fulfilled = true;
    }



    //Multitasker stuff
    @WrapOperation(method = "generateTask", at = @At(value = "INVOKE", target = "Ljava/util/Map;isEmpty()Z"))
    private boolean submerged$removeTaskLimitForMultitasker(Map instance, Operation<Boolean> original) {
        return original.call(instance) || WorldModifierComponent.KEY.get(this.player.getWorld()).isModifier(this.player, SubmergedModifiers.MULTITASKER);
    }

    @WrapOperation(method = "serverTick", at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(II)I"))
    private int submerged$multitaskerTaskCooldown(int a, int b, Operation<Integer> original) {
        if (WorldModifierComponent.KEY.get(this.player.getWorld()).isModifier(this.player, SubmergedModifiers.MULTITASKER)) {
            return Math.max(original.call(a, b)/2, 2);
        }
        return original.call(a, b);
    }
}
