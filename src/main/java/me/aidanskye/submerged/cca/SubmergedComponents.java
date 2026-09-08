package me.aidanskye.submerged.cca;

import org.ladysnake.cca.api.v3.world.WorldComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.world.WorldComponentInitializer;

public class SubmergedComponents implements WorldComponentInitializer {
    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(SubmergedWorldMapComponent.KEY, SubmergedWorldMapComponent::new);
    }
}
