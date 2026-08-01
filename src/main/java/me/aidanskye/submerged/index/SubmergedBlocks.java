package me.aidanskye.submerged.index;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.block.BalloonBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SubmergedBlocks {

    public static Block redBalloonBlock = registerBlock("red_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block greenBalloonBlock = registerBlock("green_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block blueBalloonBlock = registerBlock("blue_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block yellowBalloonBlock = registerBlock("yellow_balloon", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block redAndYellowBalloonBlock = registerBlock("red_and_yellow_balloons", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));
    public static Block greenAndBlueBalloonBlock = registerBlock("green_and_blue_balloons", new BalloonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque().breakInstantly().noCollision()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Submerged.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Submerged.id(name), new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {}
}
