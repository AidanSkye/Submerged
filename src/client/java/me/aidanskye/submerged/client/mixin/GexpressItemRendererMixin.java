package me.aidanskye.submerged.client.mixin;

import dev.doctor4t.wathe.index.WatheDataComponentTypes;
import dev.doctor4t.wathe.index.WatheItems;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class GexpressItemRendererMixin {
    @Unique
    private static final Identifier NOELLES_FAKE_REVOLVER = Identifier.of("noellesroles", "fake_revolver");

    @Inject(method = "renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V",
            at = @At("HEAD"), cancellable = true)
    private void gexpress$renderFakeKnifeWithRealSkin(LivingEntity entity, ItemStack stack,
                                                      ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices,
                                                      net.minecraft.client.render.VertexConsumerProvider vertexConsumers, World world,
                                                      int light, int overlay, int seed, CallbackInfo ci) {
        ItemStack renderStack = fakeRevolverRenderStack(stack, entity);
        if (renderStack == stack) return;
        ((ItemRenderer) (Object) this).renderItem(entity, renderStack, renderMode, leftHanded, matrices,
                vertexConsumers, world, light, overlay, seed);
        ci.cancel();
    }

    @Unique
    private static ItemStack fakeRevolverRenderStack(ItemStack stack, LivingEntity entity) {
        if (isNoellesFakeRevolver(stack) && entity != null) {
            ItemStack revolver = WatheItems.REVOLVER.getDefaultStack();
            revolver.set(WatheDataComponentTypes.OWNER, entity.getUuidAsString());
            NbtComponent preview = stack.get(DataComponentTypes.CUSTOM_DATA);
            if (preview != null && preview.copyNbt().contains("gexpress_skin_preview")) {
                revolver.set(DataComponentTypes.CUSTOM_DATA, preview);
            }

            return revolver;
        } else {
            return stack;
        }
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
