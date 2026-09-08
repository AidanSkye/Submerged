package me.aidanskye.submerged.index;

import dev.doctor4t.ratatouille.util.registrar.EntityTypeRegistrar;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.entity.BonnieEntity;
import me.aidanskye.submerged.entity.ChicaEntity;
import me.aidanskye.submerged.entity.ElevatorEntity;
import me.aidanskye.submerged.entity.FreddyEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public interface SubmergedEntities {
    EntityTypeRegistrar registrar = new EntityTypeRegistrar(Submerged.MOD_ID);

    EntityType<ElevatorEntity> ELEVATOR = registrar.create("elevator", EntityType.Builder.create(ElevatorEntity::new, SpawnGroup.MISC)
            .dimensions(3, 1)
            .maxTrackingRange(128)
    );

    EntityType<FreddyEntity> FREDDY = registrar.create("freddy", EntityType.Builder.create(FreddyEntity::new, SpawnGroup.MISC)
            .dimensions(1, 2.5f)
            .maxTrackingRange(128)
    );

    EntityType<BonnieEntity> BONNIE = registrar.create("bonnie", EntityType.Builder.create(BonnieEntity::new, SpawnGroup.MISC)
            .dimensions(1, 2.5f)
            .maxTrackingRange(128)
    );

    EntityType<ChicaEntity> CHICA = registrar.create("chica", EntityType.Builder.create(ChicaEntity::new, SpawnGroup.MISC)
            .dimensions(1, 2.5f)
            .maxTrackingRange(128)
    );

    static void initialize() {
        registrar.registerEntries();
        FabricDefaultAttributeRegistry.register(SubmergedEntities.FREDDY, FreddyEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SubmergedEntities.BONNIE, BonnieEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SubmergedEntities.CHICA, ChicaEntity.createAttributes());
    }
}
