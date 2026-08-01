package me.aidanskye.submerged.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.mapselect.skin.WeaponSkin;
import dev.mapselect.skin.WeaponSkinType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//@Mixin(targets = "dev.mapselect.client.screen.GexpressSkinsCategory$SkinsPanelWidget", remap = false)
//public abstract class GexpressCaseRewardPreviewMixin {
//
//    //jesus christ, someone please send help
//    @ModifyArg(method = "weightedReelPreview", at = @At(value = "INVOKE", target = "Ldev/mapselect/client/screen/GexpressSkinsCategory$CaseRewardPreview;<init>(Ldev/mapselect/skin/WeaponSkinType;Ldev/mapselect/skin/WeaponSkin;Z)V"), index = 2)
//    private boolean weightedReelPreview(boolean mysteryKnife) {
//        return false;
//    }
//
//}

@Mixin(targets = "dev.mapselect.client.screen.GexpressSkinsCategory$CaseRewardPreview", remap = false)
public abstract class GexpressCaseRewardPreviewMixin {

    @Mutable
    @Shadow
    @Final
    private boolean mysteryKnife;

    @Inject(method = "<init>(Ldev/mapselect/skin/WeaponSkinType;Ldev/mapselect/skin/WeaponSkin;Z)V", at = @At(value = "TAIL"))
    private void submerged$forceMysteryKnifeFalse(WeaponSkinType type, WeaponSkin skin, boolean mysteryKnife, CallbackInfo ci) {
        this.mysteryKnife = false;
    }

    @Inject(method = "asMysteryPreview", at = @At(value = "HEAD"), cancellable = true)
    private void submerged$neverReturnMysteryPreview(CallbackInfoReturnable<Object> cir) {
        cir.setReturnValue(this);
    }

    @ModifyReturnValue(method = "mysteryKnife", at = @At(value = "RETURN"))
    private boolean submerged$neverMysteryKnife(boolean original) {
        return false;
    }

}
