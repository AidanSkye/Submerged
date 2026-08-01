package me.aidanskye.submerged.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.mapselect.client.render.DevWeaponModels;
import dev.mapselect.config.GexpressConfig;
import dev.mapselect.skin.WeaponSkin;
import dev.mapselect.skin.WeaponSkinType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DevWeaponModels.class)
public class FixImportedGunSkinsMixin {

    @ModifyReturnValue(method = "resolveId", at = @At(value = "RETURN"))
    private static Identifier submerged$makeGunSkinsShowRegardlessOfConfig(Identifier original, @Local(argsOnly = true, name = "stack") ItemStack stack, @Local(argsOnly = true, name = "entity") LivingEntity entity) {
        if (!usesDefaultWatheSkin(stack)) {
            return null;
        }
        WeaponSkinType type = isKnifeLike(stack) ? WeaponSkinType.KNIFE : (isGunLike(stack) ? WeaponSkinType.GUN : null);
        WeaponSkin skin = resolveSkin(stack, entity);
        if (skin != null && skin.supports(type)) {
            Identifier importedModel = skin.model(type);
            if (importedModel != null) {
                return importedModel;
            }
            return original;
        } else {
            return null;
        }
    }

    @Shadow
    private static boolean usesDefaultWatheSkin(ItemStack stack) {
        return false;
    }

    @Shadow
    public static boolean isKnifeLike(ItemStack stack) {
        return false;
    }

    @Shadow
    public static boolean isGunLike(ItemStack stack) {
        return false;
    }

    @Shadow
    private static WeaponSkin resolveSkin(ItemStack stack, LivingEntity entity) {
        return null;
    }

}
