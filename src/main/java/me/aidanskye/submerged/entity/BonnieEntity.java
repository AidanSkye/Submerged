package me.aidanskye.submerged.entity;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BonnieEntity extends AnimatronicEntity {
    public final AnimationState mainPoseAnimationState = new AnimationState();

    public BonnieEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected @Nullable AnimationState getAnimationStateFromIndex(int index) {
        return switch (index) { //switch for in case more animations are made
            case 1 -> this.mainPoseAnimationState;
            default -> null;
        };
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            super.tickAnimationStates();
        }
    }
}
