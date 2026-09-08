package me.aidanskye.submerged.item;

import dev.doctor4t.wathe.cca.PlayerMoodComponent;
import me.aidanskye.submerged.game.task.TaskFulfillmentMethods;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class JobApplicationItem extends Item {
    public JobApplicationItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setStackInHand(hand, ItemStack.EMPTY);
        ((TaskFulfillmentMethods) PlayerMoodComponent.KEY.get(user)).getAJob();
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
