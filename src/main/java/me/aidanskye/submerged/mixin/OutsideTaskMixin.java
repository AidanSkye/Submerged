package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.doctor4t.wathe.cca.PlayerMoodComponent;
import me.aidanskye.submerged.cca.SubmergedWorldMapComponent;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerMoodComponent.OutsideTask.class)
public class OutsideTaskMixin {

    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Ldev/doctor4t/wathe/Wathe;isSkyVisibleAdjacent(Lnet/minecraft/entity/Entity;)Z"))
    private static boolean submerged$supportFreshAirAreas(Entity player, Operation<Boolean> original) {
        boolean originalValue = original.call(player);
        if (!originalValue) {
            SubmergedWorldMapComponent mapComponent = SubmergedWorldMapComponent.KEY.get(player.getWorld());

            for (Box area : mapComponent.getFreshAirAreas()) {
                if (area.contains(player.getEyePos())) return true;
            }
        }
        return originalValue;
    }
}
