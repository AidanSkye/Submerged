package me.aidanskye.submerged.index;

import dev.doctor4t.ratatouille.util.registrar.EntityTypeRegistrar;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.entity.ElevatorEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public interface SubmergedEntities {
    EntityTypeRegistrar registrar = new EntityTypeRegistrar(Submerged.MOD_ID);

    EntityType<ElevatorEntity> ELEVATOR = registrar.create("elevator", EntityType.Builder.create(ElevatorEntity::new, SpawnGroup.MISC)
            .dimensions(3, 1)
            .maxTrackingRange(128)
    );

    static void initialize() {
        registrar.registerEntries();
    }
}
