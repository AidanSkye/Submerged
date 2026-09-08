package me.aidanskye.submerged.entity;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FreddyEntity extends AnimatronicEntity {
    public final AnimationState mainPoseAnimationState = new AnimationState();
    public final AnimationState stuffedAnimationState = new AnimationState();
    public final AnimationState blackEyesAnimationState = new AnimationState();

    private boolean blackEyes = false;

    public FreddyEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected @Nullable AnimationState getAnimationStateFromIndex(int index) {
        return switch (index) {
            case 1 -> this.mainPoseAnimationState;
            case 2 -> this.stuffedAnimationState;
            default -> null;
        };
    }

    private void tickBlackoutAnimation() {
        if (getAnimationTimeout() <= 0) {
            blackEyes = !blackEyes;
            if (blackEyes) {
                blackEyesAnimationState.start(this.age);
            } else {
                blackEyesAnimationState.stop();
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            super.tickAnimationStates();
            tickBlackoutAnimation();
        }
    }
}
