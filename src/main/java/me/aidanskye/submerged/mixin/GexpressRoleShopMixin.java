package me.aidanskye.submerged.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.doctor4t.wathe.util.ShopEntry;
import dev.mapselect.config.GexpressConfig;
import dev.mapselect.registry.MapSelectItems;
import dev.mapselect.role.GexpressRoleShop;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(GexpressRoleShop.class)
public abstract class GexpressRoleShopMixin {

    @ModifyReturnValue(method = "bombSpecialistList", at = @At(value = "RETURN"))
    private static List<ShopEntry> submerged$addDetonatorToBombSpecialistShop(List<ShopEntry> original) {
        List<ShopEntry> shopEntries = new ArrayList<>(original);
        shopEntries.add(new ShopEntry(new ItemStack(MapSelectItems.C4_DETONATOR), 25, ShopEntry.Type.TOOL));
        return shopEntries;
    }

}
