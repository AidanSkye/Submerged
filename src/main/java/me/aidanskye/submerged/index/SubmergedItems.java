package me.aidanskye.submerged.index;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.item.JobApplicationItem;
import me.aidanskye.submerged.item.MapCreatorItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public class SubmergedItems {
    public static final Item JOB_APPLICATION = registerItem("job_application", new JobApplicationItem(new Item.Settings()));
    public static final Item MAP_CREATOR = registerItem("map_creator", new MapCreatorItem(
            new Item.Settings().maxCount(1).rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Submerged.id(name), item);
    }

    public static void initialize() {}
}
