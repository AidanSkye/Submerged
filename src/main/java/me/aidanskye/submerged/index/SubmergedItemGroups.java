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
                    }).build());

    public static void initialize() {}
}
