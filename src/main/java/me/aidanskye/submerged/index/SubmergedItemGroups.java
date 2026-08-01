package me.aidanskye.submerged.index;

import me.aidanskye.submerged.Submerged;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class SubmergedItemGroups {

    public static final ItemGroup SUBMERGED_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Submerged.id("submerged"),
            FabricItemGroup.builder().icon(() -> new ItemStack(SubmergedBlocks.redBalloonBlock))
                    .displayName(Text.translatable("itemGroup.submerged.submerged"))
                    .entries((displayContext, entries) -> {
                        entries.add(SubmergedBlocks.redBalloonBlock);
                        entries.add(SubmergedBlocks.greenBalloonBlock);
                        entries.add(SubmergedBlocks.blueBalloonBlock);
                        entries.add(SubmergedBlocks.yellowBalloonBlock);
                        entries.add(SubmergedBlocks.redAndYellowBalloonBlock);
                        entries.add(SubmergedBlocks.greenAndBlueBalloonBlock);

                        entries.add(SubmergedBlocks.CROSS_GLASS);
                        entries.add(SubmergedBlocks.DARK_MED_FLOOR);
                        entries.add(SubmergedBlocks.DARK_WALLPAPER);
                        entries.add(SubmergedBlocks.DEC_BLUE_WALLPAPER);
                        entries.add(SubmergedBlocks.DEC_BROWN_FLOOR);
                        entries.add(SubmergedBlocks.DEC_RED_FLOOR);
                        entries.add(SubmergedBlocks.DEC_WOOD_FLOOR);
                        entries.add(SubmergedBlocks.GRAY_WALLPAPER);
                        entries.add(SubmergedBlocks.GREEN_CAF_FLOOR);
                        entries.add(SubmergedBlocks.HEAVILY_RUST_STEEL);
                        entries.add(SubmergedBlocks.LIGHT_RUST_STEEL);
                        entries.add(SubmergedBlocks.LIGHT_MED_FLOOR);
                        entries.add(SubmergedBlocks.LIGHT_PURPLE_WALLPAPER);
                        entries.add(SubmergedBlocks.LIGHT_WALLPAPER);
                        entries.add(SubmergedBlocks.MED_WALL);
                        entries.add(SubmergedBlocks.ORANGE_TILES);
                        entries.add(SubmergedBlocks.POLISHED_STEEL);
                        entries.add(SubmergedBlocks.PURPLE_CAF_FLOOR);
                        entries.add(SubmergedBlocks.PURPLE_DEC_WALLPAPER);
                        entries.add(SubmergedBlocks.PURPLE_WALLPAPER);
                        entries.add(SubmergedBlocks.SEASTONE_PILLAR);
                        entries.add(SubmergedBlocks.SEASTONE_TILES);
                        entries.add(SubmergedBlocks.SMOOTH_STEEL);
                        entries.add(SubmergedBlocks.SUBMERGED_BLUE_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_CYAN_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_DARK_SANDSTONE);
                        entries.add(SubmergedBlocks.SUBMERGED_DARK_YELLOW_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_GREEN_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_LIME_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_MAGENTA_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_PURPLE_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_RED_CARPET);
                        entries.add(SubmergedBlocks.SUBMERGED_SAND);
                        entries.add(SubmergedBlocks.SUBMERGED_SANDSTONE);
                        entries.add(SubmergedBlocks.SUBMERGED_STONE);
                        entries.add(SubmergedBlocks.SUBMERGED_YELLOW_CARPET);
                        entries.add(SubmergedBlocks.YELLOW_DEC_WALLPAPER);
                    }).build());

    public static void initialize() {}
}
