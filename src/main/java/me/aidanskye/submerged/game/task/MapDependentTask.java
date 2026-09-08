package me.aidanskye.submerged.game.task;

import dev.doctor4t.wathe.api.MapEffect;

import java.util.List;

public interface MapDependentTask {
    List<Class<? extends MapEffect>> getWhitelistedMaps();

    default boolean isMapWhitelisted(MapEffect currentMapEffect) {
        for (Class<? extends MapEffect> mapEffectClass : getWhitelistedMaps()) {
            if (mapEffectClass.isInstance(currentMapEffect)) return true;
        }
        return false;
    };
}
