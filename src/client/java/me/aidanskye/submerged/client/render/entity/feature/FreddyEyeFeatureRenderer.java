package me.aidanskye.submerged.client.render.entity.feature;

import me.aidanskye.submerged.client.index.SubmergedEntityModelLayers;
import me.aidanskye.submerged.client.render.model.FreddyEntityModel;
import me.aidanskye.submerged.entity.FreddyEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;

public class FreddyEyeFeatureRenderer extends FeatureRenderer<FreddyEntity, FreddyEntityModel> {
    private final FreddyEntityModel model;

    public FreddyEyeFeatureRenderer(FeatureRendererContext<FreddyEntity, FreddyEntityModel> context, EntityModelLoader loader) {
        super(context);
        this.model = new FreddyEntityModel(loader.getModelPart(SubmergedEntityModelLayers.FREDDY_EYES));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, FreddyEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(this.getTexture(entity)));

        this.getContextModel().copyStateTo(this.model);
        this.model.animateModel(entity, limbAngle, limbDistance, tickDelta);
        this.model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
        this.model.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(entity, 0.0F));
    }
}
