package me.aidanskye.submerged.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    //Whenever Wathe or some other addon kills a player, they always use getLastAttacker() to see who should get the money/kill credit, if someone takes over 5 seconds
    //to die, such as punching someone off a tall map or into water, this credit could get lost and the killer may not receive the money from the kill. This should fix it.
    @ModifyConstant(method = "baseTick", constant = @Constant(intValue = 100))
    private static int submerged$increaseMaxAttackTime(int ignored) {
        return 600; //30 seconds
    }

}
