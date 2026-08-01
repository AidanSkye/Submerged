package me.aidanskye.submerged.client.render.entity;

import me.aidanskye.submerged.entity.ElevatorEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class ElevatorEntityRenderer extends EntityRenderer<ElevatorEntity> {
    public ElevatorEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(ElevatorEntity entity) {
        return null;
    }
}
