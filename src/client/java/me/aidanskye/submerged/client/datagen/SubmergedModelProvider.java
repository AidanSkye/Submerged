package me.aidanskye.submerged.client.datagen;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.index.SubmergedBlocks;
import me.aidanskye.submerged.index.SubmergedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class SubmergedModelProvider extends FabricModelProvider {
    public SubmergedModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static final TextureKey SLOT_0 = TextureKey.of("0");

    public static final Model BALLOON_MODEL = new Model(Optional.of(Submerged.id("block/balloon")), Optional.empty(), SLOT_0, TextureKey.PARTICLE);
    public static final Model DOUBLE_BALLOON_MODEL = new Model(Optional.of(Submerged.id("block/double_balloon")), Optional.empty(), SLOT_0, TextureKey.PARTICLE);

    public static final TexturedModel.Factory BALLOON = TexturedModel.makeFactory(block -> new TextureMap()
            .put(SLOT_0, TextureMap.getId(block))
            .put(TextureKey.PARTICLE, TextureMap.getId(block))
    ,BALLOON_MODEL);
    public static final TexturedModel.Factory DOUBLE_BALLOON = TexturedModel.makeFactory(block -> new TextureMap()
            .put(SLOT_0, TextureMap.getId(block))
            .put(TextureKey.PARTICLE, TextureMap.getId(block))
    ,DOUBLE_BALLOON_MODEL);

    private void registerBalloon(Block block, BlockStateModelGenerator generator) {
        Identifier id = Registries.BLOCK.getId(block);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, id.withPrefixedPath("block/")))
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
        BALLOON.upload(block, generator.modelCollector);
        Models.GENERATED.upload(id.withPrefixedPath("item/"), TextureMap.layer0(id.withPrefixedPath("item/")), generator.modelCollector);
    }
    private void registerDoubleBalloon(Block block, BlockStateModelGenerator generator) {
        Identifier id = Registries.BLOCK.getId(block);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, id.withPrefixedPath("block/")))
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
        DOUBLE_BALLOON.upload(block, generator.modelCollector);
        Models.GENERATED.upload(id.withPrefixedPath("item/"), TextureMap.layer0(id.withPrefixedPath("item/")), generator.modelCollector);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        registerBalloon(SubmergedBlocks.redBalloonBlock, generator);
        registerBalloon(SubmergedBlocks.greenBalloonBlock, generator);
        registerBalloon(SubmergedBlocks.blueBalloonBlock, generator);
        registerBalloon(SubmergedBlocks.yellowBalloonBlock, generator);
        registerDoubleBalloon(SubmergedBlocks.redAndYellowBalloonBlock, generator);
        registerDoubleBalloon(SubmergedBlocks.greenAndBlueBalloonBlock, generator);

        generator.registerSimpleCubeAll(SubmergedBlocks.CROSS_GLASS);
        generator.registerSimpleCubeAll(SubmergedBlocks.DARK_MED_FLOOR);
        generator.registerSimpleCubeAll(SubmergedBlocks.DARK_WALLPAPER);
        generator.registerSimpleCubeAll(SubmergedBlocks.DEC_BLUE_WALLPAPER);
        generator.registerSimpleCubeAll(SubmergedBlocks.DEC_BROWN_FLOOR);
        generator.registerSimpleCubeAll(SubmergedBlocks.DEC_RED_FLOOR);
        generator.registerSimpleCubeAll(SubmergedBlocks.DEC_WOOD_FLOOR);
        generator.registerSimpleCubeAll(SubmergedBlocks.GRAY_WALLPAPER);
        generator.registerSimpleCubeAll(SubmergedBlocks.GREEN_CAF_FLOOR);
        generator.registerSimpleCubeAll(SubmergedBlocks.HEAVILY_RUST_STEEL);
        generator.registerSimpleCubeAll(SubmergedBlocks.LIGHT_RUST_STEEL);
        generator.registerSimpleCubeAll(SubmergedBlocks.LIGHT_MED_FLOOR);
        generator.registerSimpleCubeAll(SubmergedBlocks.LIGHT_PURPLE_WALLPAPER);
        generator.registerSimpleCubeAll(SubmergedBlocks.LIGHT_WALLPAPER);
        generator.registerSimpleCubeAll(SubmergedBlocks.MED_WALL);
        generator.registerSimpleCubeAll(SubmergedBlocks.ORANGE_TILES);
        generator.registerSimpleCubeAll(SubmergedBlocks.POLISHED_STEEL);
        generator.registerSimpleCubeAll(SubmergedBlocks.PURPLE_CAF_FLOOR);
        generator.registerSimpleCubeAll(SubmergedBlocks.PURPLE_DEC_WALLPAPER);
        generator.registerSimpleCubeAll(SubmergedBlocks.PURPLE_WALLPAPER);
        generator.registerSimpleCubeAll(SubmergedBlocks.SEASTONE_PILLAR);
        generator.registerSimpleCubeAll(SubmergedBlocks.SEASTONE_TILES);
        generator.registerSimpleCubeAll(SubmergedBlocks.SMOOTH_STEEL);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_BLUE_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_CYAN_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_DARK_SANDSTONE);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_DARK_YELLOW_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_GREEN_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_LIME_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_MAGENTA_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_PURPLE_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_RED_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_SAND);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_SANDSTONE);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_STONE);
        generator.registerSimpleCubeAll(SubmergedBlocks.SUBMERGED_YELLOW_CARPET);
        generator.registerSimpleCubeAll(SubmergedBlocks.YELLOW_DEC_WALLPAPER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(SubmergedItems.JOB_APPLICATION, Models.GENERATED);
        generator.register(SubmergedItems.MAP_CREATOR, Items.STICK, Models.GENERATED);
    }
}










//    public static final Model KNIFE_TEMPLATE = new Model(Optional.of(Wathe.id("item/template_knife")), Optional.empty(), TextureKey.LAYER0);
//    public static final Model REVOLVER_TEMPLATE = new Model(Optional.of(Submerged.id("item/template_revolver")), Optional.empty(), TextureKey.LAYER0);




//        for (String name : Submerged.knifeSkins) {
//            registerKnifeSkin(name, generator);
//        }
//        for (String name : Submerged.revolverSkins) {
//            registerRevolverSkin(name, generator);
//        }


//    private void registerKnifeSkin(@Nullable String name, ItemModelGenerator generator) {
//        registerTemplateWeapon(KNIFE_TEMPLATE, name, Submerged.id("knife"), generator);
//    }
//
//    private void registerRevolverSkin(@Nullable String name, ItemModelGenerator generator) {
//        registerTemplateWeapon(REVOLVER_TEMPLATE, name, Submerged.id("revolver"), generator);
//    }
//
//    private void registerTemplateWeapon(Model templateModel, @Nullable String name, Identifier itemId, ItemModelGenerator generator) {
//        Identifier modelName = (name == null ? getItemId(itemId) : getItemSubId(itemId, "_" + name));
//        Identifier texture = (name == null ? getItemId(itemId) : getItemSubId(itemId, "_" + name));
//
//        templateModel.upload(modelName, TextureMap.layer0(texture), generator.writer);
//    }
//
//    public static Identifier getItemId(Identifier itemId) {
//        return itemId.withPrefixedPath("item/");
//    }
//
//    public static Identifier getItemSubId(Identifier itemId, String suffix) {
//        return itemId.withPath(path -> "item/" + path + suffix);
//    }