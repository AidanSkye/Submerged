package me.aidanskye.submerged.item;

import dev.doctor4t.wathe.cca.MapVariablesWorldComponent;
import dev.doctor4t.wathe.game.GameConstants;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

//TODO change the hardcoded messages to use language entries
public class MapCreatorItem extends Item {
    //yes I'm using fields to store data on an item, I'm too lazy to do this the right way. I'll change this to use components eventually...
    private boolean startedWizard = false;

    private Vec3i mapOrigin = null;
    private Vec3i lobbyOrigin = null;

    private MapVariablesWorldComponent.PosWithOrientation spawnPos = null;
    private MapVariablesWorldComponent.PosWithOrientation spectatorSpawnPos = null;

    private Box readyArea = null;
    private Vec3i playAreaOffset = null;
    private Box playArea = null;

    private Box resetTemplateArea = null;
    private Vec3i resetPasteOffset = null;

    private MapVariablesWorldComponent.PosWithOrientation readyAreaSpawnPos = null;


    private BlockPos readyAreaPos1 = null;

    private BlockPos playAreaPos1 = null;

    private BlockPos resetTemplateAreaPos1 = null;

    private BlockPos playAreaOffsetPos1 = null;

    private BlockPos resetPasteOffsetPos1 = null;

    public MapCreatorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient || !(user instanceof ServerPlayerEntity player)) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        if (!startedWizard) {
            startedWizard = true;
            player.sendMessage(Text.literal("Welcome to the Map Creation Wizard! To start, right click the §cMap Origin§r."));
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        HitResult hit = player.raycast(player.getBlockInteractionRange(), 1.0f, false);
        if (hit == null || hit.getType() != HitResult.Type.BLOCK) TypedActionResult.pass(user.getStackInHand(hand));

        BlockHitResult blockHit = (BlockHitResult) hit;
        if (blockHit == null || blockHit.getBlockPos() == null) TypedActionResult.pass(user.getStackInHand(hand));

        BlockPos blockPos = blockHit.getBlockPos();

        //mapOrigin -> specSpawnPos -> playArea -> templateArea -> pasteOffset -> lobbyOrigin -> spawnPos -> readyArea -> readyAreaSpawnPos -> playAreaOffset -> export!
        //this is a mess :sob:
        if (mapOrigin == null) {
            mapOrigin = blockPos;
            player.sendMessage(Text.literal("§aMap Origin §rset! Next, right click once you are at the location you want the §cSpectator Spawn Point §rto be."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (spectatorSpawnPos == null) {
            spectatorSpawnPos = new MapVariablesWorldComponent.PosWithOrientation(player.getPos().subtract(Vec3d.of(mapOrigin)), player.getYaw(), player.getPitch());
            player.sendMessage(Text.literal("§aSpectator Spawn Point §rset! Next, right click the first corner of the §cPlay Area§r."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (playArea == null) {
            if (playAreaPos1 == null) {
                playAreaPos1 = blockPos;
                player.sendMessage(Text.literal("§aPlay Area Pos1 §rset! Next, right click the opposite corner of the §cPlay Area§r."));
                return TypedActionResult.success(user.getStackInHand(hand));
            }
            playArea = new Box(Vec3d.of(playAreaPos1.subtract(mapOrigin)), Vec3d.of(blockPos.subtract(mapOrigin)));
            player.sendMessage(Text.literal("§aPlay Area §rset! Next, right click the first corner of the §cTemplate Area§r."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (resetTemplateArea == null) {
            if (resetTemplateAreaPos1 == null) {
                resetTemplateAreaPos1 = blockPos;
                player.sendMessage(Text.literal("§aTemplate Area Pos1 §rset! Next, right click the opposite corner of the §cTemplate Area§r."));
                return TypedActionResult.success(user.getStackInHand(hand));
            }
            resetTemplateArea = new Box(Vec3d.of(resetTemplateAreaPos1.subtract(mapOrigin)), Vec3d.of(blockPos.subtract(mapOrigin)));
            player.sendMessage(Text.literal("§aTemplate Area §rset! Next, right click §cany block inside the Template Area§r."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (resetPasteOffset == null) {
            if (resetPasteOffsetPos1 == null) {
                resetPasteOffsetPos1 = blockPos;
                player.sendMessage(Text.literal("§aPaste Offset Pos1 §rset! Next, right click the §ccorresponding block in the Play Area§r."));
                return TypedActionResult.success(user.getStackInHand(hand));
            }
            //doesn't need to be offset by the mapOrigin because this is the offset between the template area and the play area
            resetPasteOffset = blockPos.subtract(resetPasteOffsetPos1);
            player.sendMessage(Text.literal("§aPaste Offset §rset! Next, right click the §cLobby Origin§r."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (lobbyOrigin == null) {
            lobbyOrigin = blockPos;
            player.sendMessage(Text.literal("§aLobby Origin §rset! Next, right click once you are at the location you want the §cSpawn Point §rto be."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (spawnPos == null) {
            spawnPos = new MapVariablesWorldComponent.PosWithOrientation(player.getPos().subtract(Vec3d.of(lobbyOrigin)), player.getYaw(), player.getPitch());
            player.sendMessage(Text.literal("§aSpawn Point §rset! Next, right click the first corner of the §cReady Area§r."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (readyArea == null) {
            if (readyAreaPos1 == null) {
                readyAreaPos1 = blockPos;
                player.sendMessage(Text.literal("§aReady Area Pos1 §rset! Next, right click the opposite corner of the §cReady Area§r."));
                return TypedActionResult.success(user.getStackInHand(hand));
            }
            readyArea = new Box(Vec3d.of(readyAreaPos1.subtract(lobbyOrigin)), Vec3d.of(blockPos.subtract(lobbyOrigin)));
            player.sendMessage(Text.literal("§aReady Area §rset! Next, right click once you are at the location you want the §cReady Area Spawn Position §rto be."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (readyAreaSpawnPos == null) {
            readyAreaSpawnPos = new MapVariablesWorldComponent.PosWithOrientation(player.getPos().subtract(Vec3d.of(lobbyOrigin)), player.getYaw(), player.getPitch());
            player.sendMessage(Text.literal("§aReady Area Spawn Position §rset! Next, right click §cany block inside of the Ready Area§r."));
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (playAreaOffset == null) {
            if (playAreaOffsetPos1 == null) {
                playAreaOffsetPos1 = blockPos;
                player.sendMessage(Text.literal("§aPlay Area Offset Pos1 §rset! Next, right click the §ccorresponding block in the Play Area§r."));
                return TypedActionResult.success(user.getStackInHand(hand));
            }
            //a vector from the arbitrary block inside the ready area to the minimum corner of the ready area
            Vec3d cornerOffset = readyArea.getMinPos().subtract(Vec3d.of(playAreaOffsetPos1.subtract(lobbyOrigin)));
            Vec3d playAreaMinimumCorner = Vec3d.of(blockPos.subtract(mapOrigin)).add(cornerOffset);

            Vec3d offset = playAreaMinimumCorner;//.subtract(Vec3d.of(mapOrigin));
            playAreaOffset = new Vec3i((int) Math.floor(offset.x), (int) Math.floor(offset.y), (int) Math.floor(offset.z));
            player.sendMessage(Text.literal("§aPlay Area Offset §rset!"));
        }

        if (player.isSneaking()) {
            startedWizard = false;

            mapOrigin = null;
            lobbyOrigin = null;

            spawnPos = null;
            spectatorSpawnPos = null;

            readyArea = null;
            playAreaOffset = null;
            playArea = null;

            resetTemplateArea = null;
            resetPasteOffset = null;

            readyAreaSpawnPos = null;

            readyAreaPos1 = null;
            playAreaPos1 = null;
            resetTemplateAreaPos1 = null;
            playAreaOffsetPos1 = null;
            resetPasteOffsetPos1 = null;

            player.sendMessage(Text.literal("Map Creation Wizard reset! Right click again to restart the wizard!"));
            return TypedActionResult.success(user.getStackInHand(hand));
        }

        String export = String.format(
                """
                {
                  "defaultMapEffect": "wathe:generic",
                
                  "mapOrigin": [%1$d, %2$d, %3$d],
                  "lobbyOrigin": [%4$d, %5$d, %6$d],
                
                  "spawnPos": [%7$.3f, %8$.3f, %9$.3f, %10$.2f, %11$.2f],
                  "spectatorSpawnPos": [%12$.3f, %13$.3f, %14$.3f, %15$.2f, %16$.2f],
                
                  "readyArea": [%17$d, %18$d, %19$d, %20$d, %21$d, %22$d],
                  "playAreaOffset": [%23$d, %24$d, %25$d],
                  "playArea": [%26$d, %27$d, %28$d, %29$d, %30$d, %31$d],
                
                  "resetTemplateArea": [%32$d, %33$d, %34$d, %35$d, %36$d, %37$d],
                  "resetPasteOffset": [%38$d, %39$d, %40$d],
                
                  "readyAreaSpawnPos": [%41$.3f, %42$.3f, %43$.3f, %44$.2f, %45$.2f]
                }
                """,
                mapOrigin.getX(), mapOrigin.getY(), mapOrigin.getZ(),
                lobbyOrigin.getX(), lobbyOrigin.getY(), lobbyOrigin.getZ(),
                spawnPos.pos.x, spawnPos.pos.y, spawnPos.pos.z, spawnPos.yaw, spawnPos.pitch,
                spectatorSpawnPos.pos.x, spectatorSpawnPos.pos.y, spectatorSpawnPos.pos.z, spectatorSpawnPos.yaw, spectatorSpawnPos.pitch,
                (int) readyArea.getMinPos().getX(), (int) readyArea.getMinPos().getY(), (int) readyArea.getMinPos().getZ(), (int) readyArea.getMaxPos().getX(), (int) readyArea.getMaxPos().getY(), (int) readyArea.getMaxPos().getZ(),
                playAreaOffset.getX(), playAreaOffset.getY(), playAreaOffset.getZ(),
                (int) playArea.getMinPos().getX(), (int) playArea.getMinPos().getY(), (int) playArea.getMinPos().getZ(), (int) playArea.getMaxPos().getX(), (int) playArea.getMaxPos().getY(), (int) playArea.getMaxPos().getZ(),
                (int) resetTemplateArea.getMinPos().getX(), (int) resetTemplateArea.getMinPos().getY(), (int) resetTemplateArea.getMinPos().getZ(), (int) resetTemplateArea.getMaxPos().getX(), (int) resetTemplateArea.getMaxPos().getY(), (int) resetTemplateArea.getMaxPos().getZ(),
                resetPasteOffset.getX(), resetPasteOffset.getY(), resetPasteOffset.getZ(),
                readyAreaSpawnPos.pos.x, readyAreaSpawnPos.pos.y, readyAreaSpawnPos.pos.z, readyAreaSpawnPos.yaw, readyAreaSpawnPos.pitch
        );

        player.sendMessage(Text.literal("You've completed the Map Creation Wizard! Click here to copy the map data to your clipboard.").setStyle(Style.EMPTY.withClickEvent(
                new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, export)).withHoverEvent(
                        new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.literal("Copy to clipboard."))
        )));
        player.sendMessage(Text.literal("Crouch+Right click to reset the Map Creation Wizard."));

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
