package me.aidanskye.submerged.client;

import me.aidanskye.submerged.client.datagen.SubmergedLootTableProvider;
import me.aidanskye.submerged.client.datagen.SubmergedModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SubmergedDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(SubmergedModelProvider::new);
        pack.addProvider(SubmergedLootTableProvider::new);
    }
}
