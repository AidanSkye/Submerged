package me.aidanskye.submerged;

import dev.doctor4t.wathe.cca.PlayerShopComponent;
import dev.doctor4t.wathe.game.GameConstants;
import dev.doctor4t.wathe.index.WatheItems;
import dev.doctor4t.wathe.util.ShopEntry;
import me.aidanskye.submerged.command.SetMapCommand;
import me.aidanskye.submerged.game.mapeffect.SubmergedMapEffects;
import me.aidanskye.submerged.index.SubmergedBlocks;
import me.aidanskye.submerged.index.SubmergedEntities;
import me.aidanskye.submerged.index.SubmergedItemGroups;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Submerged implements ModInitializer {
    public static final String MOD_ID = "submerged";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static @NotNull Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        SubmergedItemGroups.initialize();
        SubmergedEntities.initialize();
        SubmergedBlocks.initialize();

        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            SetMapCommand.register(dispatcher);
        }));
        SubmergedMapEffects.registerMapEffects();

        GameConstants.SHOP_ENTRIES.set(1, new ShopEntry(WatheItems.REVOLVER.getDefaultStack(), 250, ShopEntry.Type.WEAPON));
        GameConstants.SHOP_ENTRIES.set(9, new ShopEntry(WatheItems.BODY_BAG.getDefaultStack(), 100, ShopEntry.Type.TOOL));
        GameConstants.SHOP_ENTRIES.set(10, new ShopEntry(WatheItems.BLACKOUT.getDefaultStack(), 100, ShopEntry.Type.TOOL) {
            @Override
            public boolean onBuy(@NotNull PlayerEntity player) {
                return PlayerShopComponent.useBlackout(player);
            }
        });
    }

    public static interface SubmergedDeathReasons {
        Identifier FELL_INTO_LAVA = Submerged.id("fell_into_lava");
        Identifier CRUSHED_BY_ELEVATOR = Submerged.id("elevator_crush");
        Identifier FELL_INTO_ELEVATOR = Submerged.id("elevator_fall");
    }

    public static Set<Block> BLACKOUT_BLOCKS = Set.of(
            Blocks.CAMPFIRE,
            Blocks.SOUL_CAMPFIRE
    );

    public static Set<String> knifeSkins = Set.of(
            "bloody",
            "carrot",
            "dark_blade",
            "energy",
            "fork",
            "glass",
            "plasma",
            "butter",
            "zenith"
    );

    public static Set<String> revolverSkins = Set.of(
            "banana",
            "fish",
            "glass",
            "handgun",
            "ketchup",
            "marksman",
            "shark"
    );

//    public static void main(String[] args) {
//        System.out.println(new Color(Color.decode("#E8D401").getRGB()*-1).getRGB()*-1);
//    }

}
