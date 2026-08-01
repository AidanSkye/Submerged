package me.aidanskye.submerged.client.gui;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

public class TestRenderer {

    public static void renderHud(TextRenderer renderer, @NotNull ClientPlayerEntity player, DrawContext context, RenderTickCounter tickCounter) {
        String text = "Wowie! This is text on the HUD!";
        context.getMatrices().push();
        context.getMatrices().translate(context.getScaledWindowWidth() / 2f, 0, 0);
        context.getMatrices().scale(0.6f, 0.6f, 1f);
        int nameWidth = renderer.getWidth(text);
        context.drawTextWithShadow(renderer, text, -nameWidth / 2, 16, MathHelper.packRgb(1f, 0f, 0f) | ((int) 255 << 24));
        context.getMatrices().pop();
    }
}
