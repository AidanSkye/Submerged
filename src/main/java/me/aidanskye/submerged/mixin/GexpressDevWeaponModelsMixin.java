package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.doctor4t.wathe.index.WatheItems;
import dev.mapselect.client.render.DevWeaponModels;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DevWeaponModels.class)
public abstract class GexpressDevWeaponModelsMixin {
    private static final Identifier NOELLES_FAKE_REVOLVER = Identifier.of("noellesroles", "fake_revolver");

    @ModifyReturnValue(method = "isGunLike", at = @At(value = "RETURN"))
    private static boolean isGunLike(boolean original, @Local(argsOnly = true, name = "stack") ItemStack stack) {
        return stack != null && !stack.isEmpty() && (stack.isOf(WatheItems.REVOLVER) || isNoellesFakeRevolver(stack));
    }

    @Unique
    private static boolean isNoellesFakeRevolver(ItemStack stack) {
        if (stack != null && !stack.isEmpty()) {
            Identifier id = Registries.ITEM.getId(stack.getItem());
            return NOELLES_FAKE_REVOLVER.equals(id) || "fake_revolver".equals(id.getPath());
        } else {
            return false;
        }
    }
}
