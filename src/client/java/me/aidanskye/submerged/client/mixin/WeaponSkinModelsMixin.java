//package me.aidanskye.submerged.client.mixin;
//
//import com.llamalad7.mixinextras.injector.ModifyReturnValue;
//import com.llamalad7.mixinextras.sugar.Local;
//import dev.mapselect.client.DevWeaponModels;
//import dev.mapselect.config.GexpressConfig;
//import dev.mapselect.skin.WeaponSkin;
//import dev.mapselect.skin.WeaponSkinType;
//import me.aidanskye.submerged.Submerged;
//import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.Identifier;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.Unique;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(DevWeaponModels.class)
//public class WeaponSkinModelsMixin {
//    //knives
//    @Unique
//    private static final Identifier BLOODY_KNIFE_MODEL = Submerged.id("item/knife_bloody");
//    @Unique
//    private static final Identifier BUTTER_KNIFE_MODEL = Submerged.id("item/knife_butter");
//    @Unique
//    private static final Identifier CARROT_KNIFE_MODEL = Submerged.id("item/knife_carrot");
//    @Unique
//    private static final Identifier DARK_BLADE_KNIFE_MODEL = Submerged.id("item/knife_dark_blade");
//    @Unique
//    private static final Identifier ENERGY_BLADE_KNIFE_MODEL = Submerged.id("item/knife_energy");
//    @Unique
//    private static final Identifier FORK_KNIFE_MODEL = Submerged.id("item/knife_fork");
//    @Unique
//    private static final Identifier GLASS_KNIFE_MODEL = Submerged.id("item/knife_glass");
//    @Unique
//    private static final Identifier PLASMA_KNIFE_MODEL = Submerged.id("item/knife_plasma");
//    @Unique
//    private static final Identifier ZENITH_KNIFE_MODEL = Submerged.id("item/knife_zenith");
//    //guns
//    @Unique
//    private static final Identifier BANANA_GUN_MODEL = Submerged.id("item/revolver_banana");
//    @Unique
//    private static final Identifier FISH_GUN_MODEL = Submerged.id("item/revolver_fish");
//    @Unique
//    private static final Identifier GLASS_GUN_MODEL = Submerged.id("item/revolver_glass");
//    @Unique
//    private static final Identifier HANDGUN_GUN_MODEL = Submerged.id("item/revolver_handgun");
//    @Unique
//    private static final Identifier KETCHUP_GUN_MODEL = Submerged.id("item/revolver_ketchup");
//    @Unique
//    private static final Identifier MARKSMAN_GUN_MODEL = Submerged.id("item/revolver_marksman");
//    @Unique
//    private static final Identifier SHARK_GUN_MODEL = Submerged.id("item/revolver_shark");
//
//    @Inject(method = "onInitializeModelLoader", at = @At(value = "TAIL"))
//    public void onInitializeModelLoader(ModelLoadingPlugin.Context pluginContext, CallbackInfo ci) {
//        pluginContext.addModels(BLOODY_KNIFE_MODEL,
//                CARROT_KNIFE_MODEL,
//                DARK_BLADE_KNIFE_MODEL,
//                ENERGY_BLADE_KNIFE_MODEL,
//                FORK_KNIFE_MODEL,
//                GLASS_KNIFE_MODEL,
//                PLASMA_KNIFE_MODEL,
//                BUTTER_KNIFE_MODEL,
//                ZENITH_KNIFE_MODEL,
//                BANANA_GUN_MODEL,
//                FISH_GUN_MODEL,
//                GLASS_GUN_MODEL,
//                HANDGUN_GUN_MODEL,
//                KETCHUP_GUN_MODEL,
//                MARKSMAN_GUN_MODEL,
//                SHARK_GUN_MODEL
//        );
//    }
//
//    @ModifyReturnValue(method = "resolveId", at = @At(value = "RETURN"))
//    private static Identifier resolveId(Identifier original, @Local(argsOnly = true, name = "stack") ItemStack stack, @Local(argsOnly = true, name = "entity") LivingEntity entity) {
//        if (original != null) {
//            return original;
//        }
//        if (!usesDefaultWatheSkin(stack)) return null;
//
//        WeaponSkinType type = isKnifeLike(stack) ? WeaponSkinType.KNIFE
//                : isGunLike(stack) ? WeaponSkinType.GUN : null;
//        WeaponSkin skin = resolveSkin(stack, entity);
//        if (skin == null || !skin.supports(type)) return null;
//        if (isKnifeLike(stack)) {
//            if (skin == WeaponSkin.DEFAULT) return null;
//            return switch (skin.id()) { //too lazy to set up whatever a class tweaker is
//                case "bloody" -> BLOODY_KNIFE_MODEL;
//                case "butter" -> BUTTER_KNIFE_MODEL;
//                case "carrot" -> CARROT_KNIFE_MODEL;
//                case "dark_blade" -> DARK_BLADE_KNIFE_MODEL;
//                case "energy" -> ENERGY_BLADE_KNIFE_MODEL;
//                case "fork" -> FORK_KNIFE_MODEL;
//                case "glass" -> GLASS_KNIFE_MODEL;
//                case "plasma" -> PLASMA_KNIFE_MODEL;
//                case "zenith" -> ZENITH_KNIFE_MODEL;
//                default -> null;
//            };
//        } else if (isGunLike(stack)) {
//            if (GexpressConfig.use3dGunSkins()) {
//                return null;
//            }
//            return switch (skin.id()) { //too lazy to set up whatever a class tweaker is
//                case "banana" -> BANANA_GUN_MODEL;
//                case "fish" -> FISH_GUN_MODEL;
//                case "glass" -> GLASS_GUN_MODEL;
//                case "handgun" -> HANDGUN_GUN_MODEL;
//                case "ketchup" -> KETCHUP_GUN_MODEL;
//                case "marksman" -> MARKSMAN_GUN_MODEL;
//                case "shark" -> SHARK_GUN_MODEL;
//                default -> null;
//            };
//        }
//        return null;
//    }
//
//    @Shadow
//    private static WeaponSkin resolveSkin(ItemStack stack, LivingEntity entity) {
//        return null;
//    }
//
//    @Shadow
//    public static boolean isKnifeLike(ItemStack stack) {
//        return false;
//    }
//
//    @Shadow
//    public static boolean isGunLike(ItemStack stack) {
//        return false;
//    }
//
//    @Shadow
//    private static boolean usesDefaultWatheSkin(ItemStack stack) {
//        return false;
//    }
//}
