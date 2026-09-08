package me.aidanskye.submerged.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Arm;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AnimatronicEntity extends LivingEntity {
    private static final TrackedData<Integer> PREVIOUSANIMATION = DataTracker.registerData(AnimatronicEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> CURRENTANIMATION = DataTracker.registerData(AnimatronicEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private int animationTimeout = 0;

    protected AnimatronicEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    protected abstract @Nullable AnimationState getAnimationStateFromIndex(int index);

    protected void tickAnimationStates() {
        if (getPreviousAnimation() != getCurrentAnimation()) {
            AnimationState previousAnimation = getAnimationStateFromIndex(getPreviousAnimation());
            if (previousAnimation != null) {
                previousAnimation.stop();
            }

            setPreviousAnimation(getCurrentAnimation());
            this.animationTimeout = 0;
        }

        if (this.animationTimeout <= 0) {
            this.animationTimeout = 100;

            AnimationState animation = getAnimationStateFromIndex(getCurrentAnimation());
            if (animation == null) return;

            animation.start(this.age);
        } else {
            --this.animationTimeout;
        }
    }

    protected int getAnimationTimeout() {
        return this.animationTimeout;
    }
    protected void setAnimationTimeout(int animationTimeout) {
        this.animationTimeout = animationTimeout;
    }
    protected void decrementAnimationTimeout() {
        this.animationTimeout--;
    }

    public int getPreviousAnimation() {
        return dataTracker.get(PREVIOUSANIMATION);
    }
    public int getCurrentAnimation() {
        return dataTracker.get(CURRENTANIMATION);
    }

    public void setPreviousAnimation(int index) {
        dataTracker.set(PREVIOUSANIMATION, index);
    }
    public void setCurrentAnimation(int index) {
        dataTracker.set(CURRENTANIMATION, index);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D);
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return DefaultedList.ofSize(4, ItemStack.EMPTY);
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {}

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(PREVIOUSANIMATION, 0);
        builder.add(CURRENTANIMATION, 1);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("PreviousAnimation", this.dataTracker.get(PREVIOUSANIMATION));
        nbt.putInt("CurrentAnimation", this.dataTracker.get(CURRENTANIMATION));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("PreviousAnimation")) this.dataTracker.set(PREVIOUSANIMATION, nbt.getInt("PreviousAnimation"));
        if (nbt.contains("CurrentAnimation")) this.dataTracker.set(CURRENTANIMATION, nbt.getInt("CurrentAnimation"));
    }

    @Override
    public boolean collidesWith(Entity other) {
        return false;
    }

    @Override
    public boolean handleAttack(Entity attacker) {
        return true;
    }

    @Override
    public void pushAwayFrom(Entity entity) {}

    @Override
    protected void pushAway(Entity entity) {}
}
