package me.aidanskye.submerged.client.gui.screen.ingame;

import me.aidanskye.submerged.Submerged;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class MapVotingScreen extends Screen {
    public static final Identifier BACKGROUND_TEXTURE = Submerged.id("textures/gui/container/map_voting.png");
    public static final int backgroundWidth = 282;
    public static final int backgroundHeight = 138;
    public int x;
    public int y;

    public Identifier map1;
    public Identifier map2;
    public Identifier map3;
    public ClientPlayerEntity player;

    public MapVotingScreen(Identifier map1, Identifier map2, Identifier map3) {
        super(Text.literal("Vote For the Next Map"));
        this.map1 = map1;
        this.map2 = map2;
        this.map3 = map3;
    }

    @Override
    protected void init() {
        super.init();
        this.x = (this.width - backgroundWidth) / 2;
        this.y = (this.height - backgroundHeight) / 2;
        if (this.client == null) return;
        if (this.client.player == null) return;
        player = this.client.player;

        ButtonWidget mapButton1 = ButtonWidget.builder(Text.of("Map 1"), (btn) -> {
            this.client.getToastManager().add(
                    SystemToast.create(this.client, SystemToast.Type.NARRATOR_TOGGLE, Text.of("Map Voted!"), Text.of("Map 1 voted."))
            );
        }).dimensions(x+7, y+7, 88, 124).build();

        ButtonWidget mapButton2 = ButtonWidget.builder(Text.of("Map 2"), (btn) -> {
            this.client.getToastManager().add(
                    SystemToast.create(this.client, SystemToast.Type.NARRATOR_TOGGLE, Text.of("Map Voted!"), Text.of("Map 2 voted."))
            );
        }).dimensions(x+97, y+7, 88, 124).build();

        ButtonWidget mapButton3 = ButtonWidget.builder(Text.of("Map 3"), (btn) -> {
            this.client.getToastManager().add(
                    SystemToast.create(this.client, SystemToast.Type.NARRATOR_TOGGLE, Text.of("Map Voted!"), Text.of("Map 3 voted."))
            );
        }).dimensions(x+187, y+7, 88, 124).build();

        this.addDrawableChild(mapButton1);
        this.addDrawableChild(mapButton2);
        this.addDrawableChild(mapButton3);
    }

//    @Override
//    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
//        super.render(context, mouseX, mouseY, delta);
//        drawBackground(context, mouseX, mouseY, delta);
//    }

    protected void drawBackground(@NotNull DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(BACKGROUND_TEXTURE, this.x, this.y, 0, 0, 0, backgroundWidth, backgroundHeight, 512, 512);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderInGameBackground(context);
        drawBackground(context, mouseX, mouseY, delta);
    }
}
