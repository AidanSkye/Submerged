package me.aidanskye.submerged.client.index;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.client.render.model.BonnieEntityModel;
import me.aidanskye.submerged.client.render.model.ChicaEntityModel;
import me.aidanskye.submerged.client.render.model.FreddyEntityModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class SubmergedEntityModelLayers {
    public static final EntityModelLayer FREDDY = createMain("freddy");
    public static final EntityModelLayer FREDDY_EYES = createEyes("freddy");
    public static final EntityModelLayer BONNIE = createMain("bonnie");
    public static final EntityModelLayer BONNIE_EYES = createEyes("bonnie");
    public static final EntityModelLayer CHICA = createMain("chica");
    public static final EntityModelLayer CHICA_EYES = createEyes("chica");

    private static EntityModelLayer createMain(String name) {
        return new EntityModelLayer(Submerged.id(name), "main");
    }
    private static EntityModelLayer createEyes(String name) {
        return new EntityModelLayer(Submerged.id(name), "eyes");
    }

    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(SubmergedEntityModelLayers.FREDDY, FreddyEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SubmergedEntityModelLayers.FREDDY_EYES, FreddyEntityModel::getEyesTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SubmergedEntityModelLayers.BONNIE, BonnieEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SubmergedEntityModelLayers.CHICA, ChicaEntityModel::getTexturedModelData);
    }
}
