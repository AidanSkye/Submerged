package me.aidanskye.submerged.client.render.entity;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.client.index.SubmergedEntityModelLayers;
import me.aidanskye.submerged.client.render.entity.feature.FreddyEyeFeatureRenderer;
import me.aidanskye.submerged.client.render.model.FreddyEntityModel;
import me.aidanskye.submerged.entity.FreddyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class FreddyEntityRenderer extends LivingEntityRenderer<FreddyEntity, FreddyEntityModel> {
    private static final Identifier TEXTURE = Submerged.id("textures/entity/freddy.png");

    public FreddyEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FreddyEntityModel(context.getPart(SubmergedEntityModelLayers.FREDDY)), 0.5F);
        this.addFeature(new FreddyEyeFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(FreddyEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(FreddyEntity entity) {
        return super.hasLabel(entity) && (entity.shouldRenderName() || entity.hasCustomName() && entity == this.dispatcher.targetedEntity);
    }
}
