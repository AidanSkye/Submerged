package me.aidanskye.submerged;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class SubmergedMixinPlugin implements IMixinConfigPlugin {
    private static final Supplier<Boolean> TRUE = () -> true;

    private static final Map<String, Supplier<Boolean>> CONDITIONS = Map.of(
            "me.aidanskye.submerged.mixin.GexpressStartCommandMixin", () -> isLoaded("gexpress"),
            "me.aidanskye.submerged.mixin.GexpressRoleShopMixin", () -> isLoaded("gexpress"),
            "me.aidanskye.submerged.mixin.PelicanManagerMixin", () -> isLoaded("gexpress"),
            "me.aidanskye.submerged.mixin.GexpressNightVisionManagerMixin", () -> isLoaded("gexpress"),
            "me.aidanskye.submerged.mixin.GexpressDevWeaponModelsMixin", () -> isLoaded("gexpress"),
            "me.aidanskye.submerged.mixin.ThiefTakeItemPacketMixin", () -> isLoaded("stupid-express") && isLoaded("kinswathe")
    );

    public static boolean isLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return CONDITIONS.getOrDefault(mixinClassName, TRUE).get();
    }

    //Unused

    @Override
    public void onLoad(String s) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
