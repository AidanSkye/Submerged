package me.aidanskye.submerged.client.render.entity;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.client.index.SubmergedEntityModelLayers;
import me.aidanskye.submerged.client.render.model.BonnieEntityModel;
import me.aidanskye.submerged.entity.BonnieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class BonnieEntityRenderer extends LivingEntityRenderer<BonnieEntity, BonnieEntityModel> {
    private static final Identifier TEXTURE = Submerged.id("textures/entity/bonnie.png");

    public BonnieEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BonnieEntityModel(context.getPart(SubmergedEntityModelLayers.BONNIE)), 0.5F);
    }

    @Override
    public Identifier getTexture(BonnieEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(BonnieEntity entity) {
        return super.hasLabel(entity) && (entity.shouldRenderName() || entity.hasCustomName() && entity == this.dispatcher.targetedEntity);
    }
}
