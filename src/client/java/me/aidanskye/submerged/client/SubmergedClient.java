package me.aidanskye.submerged.client;

import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.client.gui.screen.ingame.MapVotingScreen;
import me.aidanskye.submerged.client.render.entity.ElevatorEntityRenderer;
import me.aidanskye.submerged.index.SubmergedEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;

public class SubmergedClient implements ClientModInitializer {
    public MinecraftClient client;

    @Override
    public void onInitializeClient() {
        client = MinecraftClient.getInstance();
        EntityRendererRegistry.register(SubmergedEntities.ELEVATOR, ElevatorEntityRenderer::new);

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, phase) -> {
            dispatcher.register(ClientCommandManager.literal("map_voting_gui").executes(context -> {
//                client.setScreen(new MapVotingScreen(Submerged.id("map1"), Submerged.id("map2"), Submerged.id("map3")));
                client.send(() -> client.setScreen(new MapVotingScreen(null, null, null)));
                return 1;
            }));
        });
    }
}
