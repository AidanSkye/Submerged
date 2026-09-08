package me.aidanskye.submerged.game.mapeffect;

import dev.doctor4t.wathe.api.MapEffect;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.game.mapeffect.aidanenterprises.SubmergedDayAidanEnterprisesMapEffect;
import me.aidanskye.submerged.game.mapeffect.aidanenterprises.SubmergedNightAidanEnterprisesMapEffect;
import me.aidanskye.submerged.game.mapeffect.aidanenterprises.SubmergedSundownAidanEnterprisesMapEffect;
import me.aidanskye.submerged.game.mapeffect.clover.SubmergedNightCloverMapEffect;
import me.aidanskye.submerged.game.mapeffect.clue.SubmergedDayClueMapEffect;
import me.aidanskye.submerged.game.mapeffect.clue.SubmergedNightClueMapEffect;
import me.aidanskye.submerged.game.mapeffect.clue.SubmergedSundownClueMapEffect;
import me.aidanskye.submerged.game.mapeffect.mineshaft.SubmergedNightMineshaftMapEffect;
import me.aidanskye.submerged.game.mapeffect.polus.SubmergedDayPolusMapEffect;
import me.aidanskye.submerged.game.mapeffect.polus.SubmergedNightPolusMapEffect;
import me.aidanskye.submerged.game.mapeffect.polus.SubmergedSundownPolusMapEffect;
import me.aidanskye.submerged.game.mapeffect.tree.SubmergedNightTreeMapEffect;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedDayYachtMapEffect;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedNightYachtMapEffect;
import me.aidanskye.submerged.game.mapeffect.yacht.SubmergedSundownYachtMapEffect;
import net.minecraft.util.Identifier;

import static dev.doctor4t.wathe.api.WatheMapEffects.registerMapEffect;

public class SubmergedMapEffects {

    //Clue Map
    public static final Identifier SUBMERGED_CLUE_NIGHT_ID = Submerged.id("submerged_clue_night");
    public static final Identifier SUBMERGED_CLUE_DAY_ID = Submerged.id("submerged_clue_day");
    public static final Identifier SUBMERGED_CLUE_SUNDOWN_ID = Submerged.id("submerged_clue_sundown");

    public static final MapEffect SUBMERGED_CLUE_NIGHT = registerMapEffect(SUBMERGED_CLUE_NIGHT_ID, new SubmergedNightClueMapEffect(SUBMERGED_CLUE_NIGHT_ID));
    public static final MapEffect SUBMERGED_CLUE_DAY = registerMapEffect(SUBMERGED_CLUE_DAY_ID, new SubmergedDayClueMapEffect(SUBMERGED_CLUE_DAY_ID));
    public static final MapEffect SUBMERGED_CLUE_SUNDOWN = registerMapEffect(SUBMERGED_CLUE_SUNDOWN_ID, new SubmergedSundownClueMapEffect(SUBMERGED_CLUE_SUNDOWN_ID));

    //Aidan Enterprises Map
    public static final Identifier SUBMERGED_AIDAN_ENTERPRISES_NIGHT_ID = Submerged.id("submerged_aidan_enterprises_night");
    public static final Identifier SUBMERGED_AIDAN_ENTERPRISES_DAY_ID = Submerged.id("submerged_aidan_enterprises_day");
    public static final Identifier SUBMERGED_AIDAN_ENTERPRISES_SUNDOWN_ID = Submerged.id("submerged_aidan_enterprises_sundown");

    public static final MapEffect SUBMERGED_AIDAN_ENTERPRISES_NIGHT = registerMapEffect(SUBMERGED_AIDAN_ENTERPRISES_NIGHT_ID, new SubmergedNightAidanEnterprisesMapEffect(SUBMERGED_AIDAN_ENTERPRISES_NIGHT_ID));
    public static final MapEffect SUBMERGED_AIDAN_ENTERPRISES_DAY = registerMapEffect(SUBMERGED_AIDAN_ENTERPRISES_DAY_ID, new SubmergedDayAidanEnterprisesMapEffect(SUBMERGED_AIDAN_ENTERPRISES_DAY_ID));
    public static final MapEffect SUBMERGED_AIDAN_ENTERPRISES_SUNDOWN = registerMapEffect(SUBMERGED_AIDAN_ENTERPRISES_SUNDOWN_ID, new SubmergedSundownAidanEnterprisesMapEffect(SUBMERGED_AIDAN_ENTERPRISES_SUNDOWN_ID));

    //Yacht Map
    public static final Identifier SUBMERGED_YACHT_NIGHT_ID = Submerged.id("submerged_yacht_night");
    public static final Identifier SUBMERGED_YACHT_DAY_ID = Submerged.id("submerged_yacht_day");
    public static final Identifier SUBMERGED_YACHT_SUNDOWN_ID = Submerged.id("submerged_yacht_sundown");

    public static final MapEffect SUBMERGED_YACHT_NIGHT = registerMapEffect(SUBMERGED_YACHT_NIGHT_ID, new SubmergedNightYachtMapEffect(SUBMERGED_YACHT_NIGHT_ID));
    public static final MapEffect SUBMERGED_YACHT_DAY = registerMapEffect(SUBMERGED_YACHT_DAY_ID, new SubmergedDayYachtMapEffect(SUBMERGED_YACHT_DAY_ID));
    public static final MapEffect SUBMERGED_YACHT_SUNDOWN = registerMapEffect(SUBMERGED_YACHT_SUNDOWN_ID, new SubmergedSundownYachtMapEffect(SUBMERGED_YACHT_SUNDOWN_ID));

    //Polus Map
    public static final Identifier SUBMERGED_POLUS_NIGHT_ID = Submerged.id("submerged_polus_night");
    public static final Identifier SUBMERGED_POLUS_DAY_ID = Submerged.id("submerged_polus_day");
    public static final Identifier SUBMERGED_POLUS_SUNDOWN_ID = Submerged.id("submerged_polus_sundown");

    public static final MapEffect SUBMERGED_POLUS_NIGHT = registerMapEffect(SUBMERGED_POLUS_NIGHT_ID, new SubmergedNightPolusMapEffect(SUBMERGED_POLUS_NIGHT_ID));
    public static final MapEffect SUBMERGED_POLUS_DAY = registerMapEffect(SUBMERGED_POLUS_DAY_ID, new SubmergedDayPolusMapEffect(SUBMERGED_POLUS_DAY_ID));
    public static final MapEffect SUBMERGED_POLUS_SUNDOWN = registerMapEffect(SUBMERGED_POLUS_SUNDOWN_ID, new SubmergedSundownPolusMapEffect(SUBMERGED_POLUS_SUNDOWN_ID));

    //Mineshaft Map
    public static final Identifier SUBMERGED_MINESHAFT_NIGHT_ID = Submerged.id("submerged_mineshaft_night");

    public static final MapEffect SUBMERGED_MINESHAFT_NIGHT = registerMapEffect(SUBMERGED_MINESHAFT_NIGHT_ID, new SubmergedNightMineshaftMapEffect(SUBMERGED_MINESHAFT_NIGHT_ID));

    //Clover Point Map
    public static final Identifier SUBMERGED_CLOVER_NIGHT_ID = Submerged.id("submerged_clover_night");

    public static final MapEffect SUBMERGED_CLOVER_NIGHT = registerMapEffect(SUBMERGED_CLOVER_NIGHT_ID, new SubmergedNightCloverMapEffect(SUBMERGED_CLOVER_NIGHT_ID));

    //Tree Map
    public static final Identifier SUBMERGED_TREE_NIGHT_ID = Submerged.id("submerged_tree_night");

    public static final MapEffect SUBMERGED_TREE_NIGHT = registerMapEffect(SUBMERGED_TREE_NIGHT_ID, new SubmergedNightTreeMapEffect(SUBMERGED_TREE_NIGHT_ID));

    //Sierpinski-23
    public static final Identifier SUBMERGED_SIERPINSKI23_NIGHT_ID = Submerged.id("submerged_sierpinski23_night");

    public static final MapEffect SUBMERGED_SIERPINSKI23_NIGHT = registerMapEffect(SUBMERGED_SIERPINSKI23_NIGHT_ID, new SubmergedNightTreeMapEffect(SUBMERGED_SIERPINSKI23_NIGHT_ID));

    public static void registerMapEffects() {
        Submerged.LOGGER.info("Registered Map Effects");
    }

}
