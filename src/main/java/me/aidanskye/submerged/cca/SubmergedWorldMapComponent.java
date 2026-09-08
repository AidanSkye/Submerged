package me.aidanskye.submerged.cca;

import dev.doctor4t.wathe.Wathe;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.maps.SubmergedMap;
import me.aidanskye.submerged.maps.SubmergedMaps;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SubmergedWorldMapComponent implements AutoSyncedComponent {
    public static final ComponentKey<SubmergedWorldMapComponent> KEY = ComponentRegistry.getOrCreate(Submerged.id("map"), SubmergedWorldMapComponent.class);
    private final World world;

    public SubmergedWorldMapComponent(World world) {
        this.world = world;
    }

    public void sync() {
        KEY.sync(this.world);
    }

    SubmergedMap MAP = SubmergedMaps.HARPY_EXPRESS;

    public SubmergedMap getMap() {
        return MAP;
    }

    public void setMap(SubmergedMap map) {
        this.MAP = map;
        this.sync();
    }

    public List<Box> getFreshAirAreas() {
        return this.MAP == null ? new ArrayList<>() : this.MAP.freshAirAreas();
    }

    @Override
    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        this.MAP = SubmergedMaps.MAPS.get(Identifier.of(tag.getString("map")));
    }

    @Override
    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        tag.putString("map", SubmergedMaps.MAPS.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), this.MAP))
                .map(Map.Entry::getKey)
                .findFirst().orElse(Wathe.id("harpy_express")).toString()
        );
    }
}
