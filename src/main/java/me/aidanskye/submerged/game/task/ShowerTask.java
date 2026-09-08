package me.aidanskye.submerged.game.task;

import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.block.SprinklerBlock;
import dev.doctor4t.wathe.block_entity.SprinklerBlockEntity;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.PlayerMoodComponent;
import me.aidanskye.submerged.game.mapeffect.clue.SubmergedClueMapEffect;
import me.aidanskye.submerged.game.mapeffect.polus.SubmergedPolusMapEffect;
import me.aidanskye.submerged.game.mapeffect.tree.SubmergedTreeMapEffect;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedYachtMapEffect;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ShowerTask implements PlayerMoodComponent.TrainTask, ConditionalTask, MapDependentTask {
    private int timer;

    @Override
    public List<Class<? extends MapEffect>> getWhitelistedMaps() {
        return List.of(SubmergedClueMapEffect.class, SubmergedYachtMapEffect.class);
    }

    public ShowerTask(int time) {
        this.timer = time;
    }

    @Override
    public void tick(@NotNull PlayerEntity player) {
        if (isShowering(player) && this.timer > 0) this.timer--;
    }

    @Override
    public boolean isFulfilled(PlayerEntity player) {
        return this.timer <= 0;
    }

    @Override
    public String getName() {
        return "shower";
    }

    @Override
    public PlayerMoodComponent.Task getType() {
        return PlayerMoodComponent.Task.valueOf("SUBMERGED_SHOWER");
    }

    @Override
    public NbtCompound toNbt() {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("type", PlayerMoodComponent.Task.valueOf("SUBMERGED_SHOWER").ordinal());
        nbt.putInt("timer", this.timer);
        return nbt;
    }

    @Override
    public boolean canBeGenerated(PlayerEntity player) {
        return isMapWhitelisted(GameWorldComponent.KEY.get(player.getWorld()).getMapEffect());
    }

    public static boolean isShowering(PlayerEntity player) {
        World world = player.getWorld();

        BlockPos headBlock =  player.getBlockPos().mutableCopy().add(0, 1, 0);
        for (int i = 1; i <= 5; i++) {
            BlockPos pos = headBlock.mutableCopy().add(0, i, 0);
            BlockState state = world.getBlockState(pos);
            if (isActiveShowerBlock(world, pos, state)) return true;
        }
        return false;
    }

    public static boolean isActiveShowerBlock(World world, BlockPos pos, BlockState state) {
        return (state.getBlock() instanceof SprinklerBlock) && (world.getBlockEntity(pos) != null && (world.getBlockEntity(pos) instanceof SprinklerBlockEntity) && ((SprinklerBlockEntity) world.getBlockEntity(pos)).isPowered());
    }
}
