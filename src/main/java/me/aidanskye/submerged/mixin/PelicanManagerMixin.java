package me.aidanskye.submerged.mixin;

import com.google.common.collect.ImmutableList;
import dev.doctor4t.wathe.game.GameFunctions;
import dev.mapselect.role.pelican.PelicanManager;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = PelicanManager.class, remap = false)
public abstract class PelicanManagerMixin {

    @Inject(method = "stash", at = @At(value = "RETURN"))
    private static void stash(ServerPlayerEntity vulture, ServerPlayerEntity target, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            return;
        }

        List<List<ItemStack>> combinedInventory = ImmutableList.of(target.getInventory().main, target.getInventory().armor, target.getInventory().offHand);
        for (List<ItemStack> list : combinedInventory) {
            for (int i = 0; i < list.size(); i++) {
                ItemStack stack = list.get(i);
                if (GameFunctions.shouldDropOnDeath(stack, target)) {
                    vulture.dropItem(stack, false, false);
                    list.set(i, ItemStack.EMPTY);
                }
            }
        }
    }

}
