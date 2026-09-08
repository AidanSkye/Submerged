package me.aidanskye.submerged.game.modifier;

import me.aidanskye.submerged.Submerged;
import org.agmas.harpymodloader.modifiers.HMLModifiers;
import org.agmas.harpymodloader.modifiers.Modifier;

import java.util.ArrayList;

public class SubmergedModifiers {
    public static Modifier MULTITASKER = HMLModifiers.registerModifier(new Modifier(Submerged.id("multitasker"), 0x782EF0, new ArrayList(), new ArrayList(), false, false));

    public static void initialize() {}
}
