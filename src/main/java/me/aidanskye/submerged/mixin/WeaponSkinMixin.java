//welp, weapon skins are completely different now, time to use the new system!

//package me.aidanskye.submerged.mixin;
//
//import dev.mapselect.skin.WeaponSkin;
//import dev.mapselect.skin.WeaponSkinType;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//
//import java.util.Set;
//
//@Mixin(WeaponSkin.class)
//public enum WeaponSkinMixin {
//    SUBMERGED_BLOODY("bloody", "Bloody", 6885393, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_BUTTER("butter", "Butter Knife", 7503243, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_CARROT("carrot", "Carrot", 13730048, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_DARK_BLADE("dark_blade", "Dark Blade", 65537, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_ENERGY("energy", "Energy Blade", 4557548, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_FORK("fork", "Fork", 7503243, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_GLASS("glass", "Glass", 16711423, false, Set.of(WeaponSkinType.KNIFE, WeaponSkinType.GUN)),
//    SUBMERGED_PLASMA("plasma", "Plasma", 1341438, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_ZENITH("zenith", "Zenith", 6441658, false, Set.of(WeaponSkinType.KNIFE)),
//    SUBMERGED_BANANA("banana", "Banana", 15258625, false, Set.of(WeaponSkinType.GUN)),
//    SUBMERGED_FISH("fish", "Fish", 9691885, false, Set.of(WeaponSkinType.GUN)),
//    SUBMERGED_HANDGUN("handgun", "Handgun", 7503243, false, Set.of(WeaponSkinType.GUN)),
//    SUBMERGED_KETCHUP("ketchup", "Ketchup", 13373456, false, Set.of(WeaponSkinType.GUN)),
//    SUBMERGED_MARKSMAN("marksman", "Marksman", 7503243, false, Set.of(WeaponSkinType.GUN)),
//    SUBMERGED_SHARK("shark", "Shark", 9457414, false, Set.of(WeaponSkinType.GUN));
//
//    @Shadow
//    WeaponSkinMixin(String id, String displayName, int color, boolean unlockedByDefault, Set<WeaponSkinType> types) {
//    }
//
//    @Shadow
//    public String id() {
//        return "";
//    }
//
//}
