package me.aidanskye.submerged.entity;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import dev.doctor4t.wathe.entity.NoteEntity;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

//lowkey just ignore this entity entirely
public class ElevatorEntity extends Entity {
    private static final TrackedData<Vector3f> ORIGINALPOS = DataTracker.registerData(ElevatorEntity.class, TrackedDataHandlerRegistry.VECTOR3F);
    private static final TrackedData<Boolean> ISMOVING = DataTracker.registerData(ElevatorEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> ISMOVINGUP = DataTracker.registerData(ElevatorEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> MOVINGTICKS = DataTracker.registerData(ElevatorEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public ElevatorEntity(EntityType<?> type, World world) {
        super(type, world);
        this.intersectionChecked = true;
    }

    @Override
    public void tick() {
        if (dataTracker.get(ISMOVING)) {
            if (dataTracker.get(ISMOVINGUP) && !getWorld().isClient()) {
                dataTracker.set(MOVINGTICKS, dataTracker.get(MOVINGTICKS)+1);
            } else if (!getWorld().isClient()) {
                dataTracker.set(MOVINGTICKS, dataTracker.get(MOVINGTICKS)-1);
            }
            Vector3f originalPos = dataTracker.get(ORIGINALPOS);
            if (dataTracker.get(MOVINGTICKS) <= 0 || dataTracker.get(MOVINGTICKS) >= 60) {
                if (!getWorld().isClient) {
                    dataTracker.set(ISMOVING, false);
                    dataTracker.set(MOVINGTICKS, Math.clamp(dataTracker.get(MOVINGTICKS), 0, 60));
                }
            }
//            setPosition(originalPos.x, originalPos.y + MathHelper.lerp(dataTracker.get(MOVINGTICKS)/60.0, 0.0, 3.0), originalPos.z);
            if (dataTracker.get(ISMOVINGUP)) {
                this.setVelocity(0, 3.0 / 60.0, 0);
            } else {
                this.setVelocity(0, -3.0 / 60.0, 0);
            }
            Vec3d velocity = this.getVelocity();
            this.move(MovementType.SELF, this.getVelocity());
//            this.getWorld().getOtherEntities(this, getBoundingBox().stretch(0, 0.1, 0)).forEach((entity -> {
////                if (dataTracker.get(ISMOVINGUP)) {
////                    entity.setPosition(entity.getX(), entity.getY() + (3.0 / 60.0) + 0.02, entity.getZ());
////                } else {
////                    entity.setPosition(entity.getX(), getY() + 1.02, entity.getZ());
////                }
////                if (getWorld().isClient()) return;
////                entity.setPosition(entity.getX(), originalPos.y + MathHelper.lerp(dataTracker.get(MOVINGTICKS) / 60.0, 0.0, 3.0) + 1, entity.getZ());
//                entity.addVelocity(this.getVelocity());
//                entity.velocityModified = true;
////                entity.setPosition(entity.getX(), this.getY()+1, entity.getZ());
////                entity.setPosition(new Vec3d(entity.getX(), this.getY()+1.02, entity.getZ()).add(new Vec3d(entity.getMovement().x, 0, entity.getMovement().z)));
//
//            }));
        }
        super.tick();
    }

    public Vec3d getLastMovement() {
        return new Vec3d(getX() - prevX, getY() - prevY, getZ() - prevZ);
    }

    public boolean isMoving() {
        return dataTracker.get(ISMOVING);
    }
    public boolean isMovingUp() {
        return dataTracker.get(ISMOVINGUP);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (getWorld().isClient()) {
            return ActionResult.SUCCESS;
        }
        Vector3f originalPos = dataTracker.get(ORIGINALPOS);
        if (originalPos.x() == 0f && originalPos.y() == 0f && originalPos.z() == 0f) {
            dataTracker.set(ORIGINALPOS, new Vector3f((float) getX(), (float) getY(), (float) getZ()));
        }
        dataTracker.set(ISMOVINGUP, !dataTracker.get(ISMOVINGUP));
        dataTracker.set(ISMOVING, true);
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public boolean canHit() {
        return true;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(ORIGINALPOS, new Vector3f(0, 0, 0));
        builder.add(ISMOVING, false);
        builder.add(ISMOVINGUP, false);
        builder.add(MOVINGTICKS, 0);
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putFloat("OriginalPosX", this.dataTracker.get(ORIGINALPOS).x());
        nbt.putFloat("OriginalPosY", this.dataTracker.get(ORIGINALPOS).y());
        nbt.putFloat("OriginalPosZ", this.dataTracker.get(ORIGINALPOS).z());
        nbt.putBoolean("IsMoving", this.dataTracker.get(ISMOVING));
        nbt.putBoolean("IsMovingUp", this.dataTracker.get(ISMOVINGUP));
        nbt.putInt("MovingTicks", this.dataTracker.get(MOVINGTICKS));
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("OriginalPosX") && nbt.contains("OriginalPosY") && nbt.contains("OriginalPosZ")){
            this.dataTracker.set(ORIGINALPOS, new Vector3f(
                    nbt.getFloat("OriginalPosX"),
                    nbt.getFloat("OriginalPosY"),
                    nbt.getFloat("OriginalPosZ")
            ));
        }
        if (nbt.contains("IsMoving")) this.dataTracker.set(ISMOVING, nbt.getBoolean("IsMoving"));
        if (nbt.contains("IsMovingUp")) this.dataTracker.set(ISMOVINGUP, nbt.getBoolean("IsMovingUp"));
        if (nbt.contains("MovingTicks")) this.dataTracker.set(MOVINGTICKS, nbt.getInt("MovingTicks"));
    }

}
