package me.aidanskye.submerged.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.mapselect.config.GexpressConfig;
import dev.mapselect.skin.WeaponSkinType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "dev.mapselect.client.screen.GexpressSkinsCategory$SkinsPanelWidget", remap = false)
public abstract class GexpressSkinPanelWidgetMixin {

    @Redirect(method = "visibleDrops", at = @At(value = "INVOKE", target = "Ldev/mapselect/config/GexpressConfig$SkinCaseReward;type()Ldev/mapselect/skin/WeaponSkinType;", ordinal = 0))
    private WeaponSkinType submerged$forceGunSkinTypeToAlwaysFailCondition(GexpressConfig.SkinCaseReward instance) {
        return WeaponSkinType.GUN;
    }

}
