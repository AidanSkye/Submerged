package me.aidanskye.submerged.mixin;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import org.BsXinQin.kinswathe.roles.kidnapper.KidnapperComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pro.fazeclan.river.stupid_express.role.thief.packet.ThiefTakeItemC2SPacket;

@Mixin(ThiefTakeItemC2SPacket.class)
public abstract class ThiefTakeItemPacketMixin {

    @Inject(method = "handleThiefTakeItem", at = @At(value = "HEAD"), cancellable = true)
    private static void handleThiefTakeItem(ServerPlayerEntity thief, ServerPlayerEntity target, CallbackInfo ci) {
        if (thief == null || thief.isRemoved() || target == null || target.isRemoved()) return;
        KidnapperComponent kidnapperComponent = KidnapperComponent.KEY.get(thief);

        if (kidnapperComponent.controlTicks > 0) {
            thief.sendMessage(
                    Text.literal("You tried to steal from "+target.getName().getString()+", but your hands were tied...").withColor(Colors.LIGHT_GRAY)
            );
            ci.cancel();
        }
    }
}
