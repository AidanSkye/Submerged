package me.aidanskye.submerged.client;

import me.aidanskye.submerged.client.gui.screen.ingame.MapVotingScreen;
import me.aidanskye.submerged.client.index.SubmergedEntityModelLayers;
import me.aidanskye.submerged.client.render.entity.BonnieEntityRenderer;
import me.aidanskye.submerged.client.render.entity.ChicaEntityRenderer;
import me.aidanskye.submerged.client.render.entity.ElevatorEntityRenderer;
import me.aidanskye.submerged.client.render.entity.FreddyEntityRenderer;
import me.aidanskye.submerged.index.SubmergedBlocks;
import me.aidanskye.submerged.index.SubmergedEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.lwjgl.glfw.GLFW;

public class SubmergedClient implements ClientModInitializer {
    public MinecraftClient client;

    public static KeyBinding pos1Keybind;
    public static KeyBinding pos2Keybind;
    public static KeyBinding resultKeybind;

    public static Vec3i pos1 = Vec3i.ZERO;
    public static Vec3i pos2 = Vec3i.ZERO;

    @Override
    public void onInitializeClient() {
        client = MinecraftClient.getInstance();
        SubmergedEntityModelLayers.registerModelLayers();

        EntityRendererRegistry.register(SubmergedEntities.ELEVATOR, ElevatorEntityRenderer::new);
        EntityRendererRegistry.register(SubmergedEntities.FREDDY, FreddyEntityRenderer::new);
        EntityRendererRegistry.register(SubmergedEntities.BONNIE, BonnieEntityRenderer::new);
        EntityRendererRegistry.register(SubmergedEntities.CHICA, ChicaEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), SubmergedBlocks.CROSS_GLASS);

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, phase) -> {
            dispatcher.register(ClientCommandManager.literal("map_voting_gui").executes(context -> {
//                client.setScreen(new MapVotingScreen(Submerged.id("map1"), Submerged.id("map2"), Submerged.id("map3")));
                client.send(() -> client.setScreen(new MapVotingScreen(null, null, null)));
                return 1;
            }));
        });

        pos1Keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.submerged.pos1",
                InputUtil.Type.KEYSYM,
                InputUtil.UNKNOWN_KEY.getCode(),
                "key.category.submerged.debug"
        ));
        pos2Keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.submerged.pos2",
                InputUtil.Type.KEYSYM,
                InputUtil.UNKNOWN_KEY.getCode(),
                "key.category.submerged.debug"
        ));
        resultKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.submerged.result",
                InputUtil.Type.KEYSYM,
                InputUtil.UNKNOWN_KEY.getCode(),
                "key.category.submerged.debug"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (pos1Keybind.wasPressed()) {
                if (client.player != null && client.player.isCreative()) {
                    HitResult hit = client.crosshairTarget;
                    if (hit != null &&  hit.getType() == HitResult.Type.BLOCK) {
                        BlockHitResult blockHit = (BlockHitResult) hit;
                        pos1 = blockHit.getBlockPos();
                    }
                    client.player.sendMessage(Text.literal("Pos 1"), false);
                }
            }
            while (pos2Keybind.wasPressed()) {
                if (client.player != null && client.player.isCreative()) {
                    HitResult hit = client.crosshairTarget;
                    if (hit != null &&  hit.getType() == HitResult.Type.BLOCK) {
                        BlockHitResult blockHit = (BlockHitResult) hit;
                        pos2 = blockHit.getBlockPos();
                    }
                    client.player.sendMessage(Text.literal("Pos 2"), false);
                }
            }
            while (resultKeybind.wasPressed()) {
                if (client.player != null && client.player.isCreative()) {
                    Vec3i result = pos2.subtract(pos1);
                    client.player.sendMessage(Text.literal("Result: "+result.getX()+", "+result.getY()+", "+result.getZ()).setStyle(Style.EMPTY.withClickEvent(
                            new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.join(", ", String.valueOf(result.getX()), String.valueOf(result.getY()), String.valueOf(result.getZ())))
                    )), false);
                }
            }
        });
    }
}
