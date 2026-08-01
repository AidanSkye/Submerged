package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import me.aidanskye.submerged.entity.ElevatorEntity;
import me.aidanskye.submerged.index.SubmergedEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class ElevatorStuffEntityMixin { //ignore, from when I was trying to make my own elevators

    @Shadow
    public abstract Box getBoundingBox();

    @Shadow
    public abstract World getWorld();

    @Shadow
    public abstract void sendMessage(Text message);

    @Shadow
    public boolean groundCollision;
    @Shadow
    public boolean verticalCollision;
    @Unique
    protected ElevatorEntity attachedElevator;

    @Inject(method = "move", at = @At("HEAD"))
    public void submerged$addElevatorMovementToEntity(MovementType movementType, Vec3d movement, CallbackInfo ci) {
//        if (this.attachedElevator != null && this.attachedElevator.isMoving() && this.attachedElevator.isMovingUp()) {
        if (this.attachedElevator != null) {
            movement = movement.add(this.attachedElevator.getVelocity());
        }
    }

    @Definition(id = "adjustMovementForCollisions", method = "Lnet/minecraft/entity/Entity;adjustMovementForCollisions(Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/Vec3d;")
    @Expression("? = ?.adjustMovementForCollisions(?)")
    @Inject(method = "move", at = @At(value = "MIXINEXTRAS:EXPRESSION", shift = At.Shift.AFTER))
    public void submerged$setAttachedElevator(MovementType movementType, Vec3d movement, CallbackInfo ci) {
        this.attachedElevator = null;
        getWorld().getOtherEntities(((Entity)(Object)this), this.getBoundingBox().stretch(0, -0.1, 0)).forEach(entity -> {
            if (entity.getType() == SubmergedEntities.ELEVATOR) {
                this.attachedElevator = (ElevatorEntity) entity;
            }
        });
    }

    @Inject(method = "move", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;hasVehicle()Z", shift = At.Shift.AFTER))
    public void submerged$subtractElevatorMovement(MovementType movementType, Vec3d movement, CallbackInfo ci, @Local(name = "vec3d") Vec3d vec3d) {
        Vec3d elevatorLastMovement = this.attachedElevator != null ? this.attachedElevator.getLastMovement() : Vec3d.ZERO;
        vec3d = vec3d.subtract(elevatorLastMovement);
    }

    @Redirect(method = "move", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;groundCollision:Z", opcode = Opcodes.PUTFIELD))
    private void submerged$elevatorGroundCollision(Entity instance, boolean value, @Local(name = "movement") Vec3d movement) {
        if (this.attachedElevator != null) {
            this.groundCollision = movement.y < this.attachedElevator.getLastMovement().y;
        } else {
            this.groundCollision = this.verticalCollision && movement.y < 0.0;
        }
    }

    @Inject(method = "fall", at = @At(value = "HEAD"), cancellable = true)
    protected void submerged$cancelFallElevator(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition, CallbackInfo ci) {
        if (this.attachedElevator != null) {
            ci.cancel();
        }
    }
}
