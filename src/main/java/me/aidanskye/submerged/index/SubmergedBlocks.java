package me.aidanskye.submerged.index;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.block.BalloonBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

public class SubmergedBlocks {

    public static Block redBalloonBlock = registerBlock("red_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block greenBalloonBlock = registerBlock("green_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block blueBalloonBlock = registerBlock("blue_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block yellowBalloonBlock = registerBlock("yellow_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block redAndYellowBalloonBlock = registerBlock("red_and_yellow_balloons", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block greenAndBlueBalloonBlock = registerBlock("green_and_blue_balloons", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));

    public static final Block CROSS_GLASS = registerBlock( "cross_glass", new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final Block DARK_MED_FLOOR = registerBlock( "dark_med_floor", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)));
    public static final Block DARK_WALLPAPER = registerBlock( "dark_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block DEC_BLUE_WALLPAPER = registerBlock( "dec_blue_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block DEC_BROWN_FLOOR = registerBlock( "dec_brown_floor", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block DEC_RED_FLOOR = registerBlock( "dec_red_floor", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block DEC_WOOD_FLOOR = registerBlock( "dec_wood_floor", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD)));
    public static final Block GRAY_WALLPAPER = registerBlock( "gray_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block GREEN_CAF_FLOOR = registerBlock( "green_caf_floor", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.TUFF)));
    public static final Block HEAVILY_RUST_STEEL = registerBlock( "heavily_rust_steel", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block LIGHT_RUST_STEEL = registerBlock( "light_rust_steel", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block LIGHT_MED_FLOOR = registerBlock( "light_med_floor",new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)));
    public static final Block LIGHT_PURPLE_WALLPAPER = registerBlock( "light_purple_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block LIGHT_WALLPAPER = registerBlock( "light_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block MED_WALL = registerBlock( "med_wall", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)));
    public static final Block ORANGE_TILES = registerBlock( "orange_tiles", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.TUFF)));
    public static final Block POLISHED_STEEL = registerBlock( "polished_steel", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block PURPLE_CAF_FLOOR = registerBlock( "purple_caf_floor", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.TUFF)));
    public static final Block PURPLE_DEC_WALLPAPER = registerBlock( "purple_dec_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block PURPLE_WALLPAPER = registerBlock( "purple_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SEASTONE_PILLAR = registerBlock( "seastone_pillar", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.CALCITE)));
    public static final Block SEASTONE_TILES = registerBlock( "seastone_tiles", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.CALCITE)));
    public static final Block SMOOTH_STEEL = registerBlock( "smooth_steel", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block SUBMERGED_BLUE_CARPET = registerBlock( "submerged_blue_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_CYAN_CARPET = registerBlock( "submerged_cyan_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_DARK_SANDSTONE= registerBlock( "submerged_dark_sandstone", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)));
    public static final Block SUBMERGED_DARK_YELLOW_CARPET = registerBlock( "submerged_dark_yellow_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_GREEN_CARPET = registerBlock( "submerged_green_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_LIME_CARPET = registerBlock( "submerged_lime_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_MAGENTA_CARPET = registerBlock("submerged_magenta_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_PURPLE_CARPET = registerBlock( "submerged_purple_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_RED_CARPET = registerBlock( "submerged_red_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block SUBMERGED_SAND = registerBlock( "submerged_sand", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.SAND)));
    public static final Block SUBMERGED_SANDSTONE = registerBlock( "submerged_sandstone", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)));
    public static final Block SUBMERGED_STONE = registerBlock( "submerged_stone", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block SUBMERGED_YELLOW_CARPET = registerBlock( "submerged_yellow_carpet", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));
    public static final Block YELLOW_DEC_WALLPAPER = registerBlock( "yellow_dec_wallpaper", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Submerged.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Submerged.id(name), new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {}
}
