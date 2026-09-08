package me.aidanskye.submerged.client.render.entity;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.client.index.SubmergedEntityModelLayers;
import me.aidanskye.submerged.client.render.model.ChicaEntityModel;
import me.aidanskye.submerged.entity.ChicaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class ChicaEntityRenderer extends LivingEntityRenderer<ChicaEntity, ChicaEntityModel> {
    private static final Identifier TEXTURE = Submerged.id("textures/entity/chica.png");

    public ChicaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ChicaEntityModel(context.getPart(SubmergedEntityModelLayers.CHICA)), 0.5F);
    }

    @Override
    public Identifier getTexture(ChicaEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(ChicaEntity entity) {
        return super.hasLabel(entity) && (entity.shouldRenderName() || entity.hasCustomName() && entity == this.dispatcher.targetedEntity);
    }
}
