package me.aidanskye.submerged.client.mixin;

import me.aidanskye.submerged.client.gui.TestRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "renderMainHud", at = @At("TAIL"))
    private void submerged$renderHud(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        ClientPlayerEntity player = this.client.player;
        if (player == null) return;
        TextRenderer renderer = MinecraftClient.getInstance().textRenderer;
        TestRenderer.renderHud(renderer, player, context, tickCounter);
    }
}
