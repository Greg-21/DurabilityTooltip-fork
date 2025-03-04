package com.supermartijn642.durabilitytooltip;

import com.supermartijn642.configlib.api.ConfigBuilders;
import com.supermartijn642.configlib.api.IConfigBuilder;
import net.minecraft.ChatFormatting;

import java.util.function.Supplier;

/**
 * Created 01/12/2021 by SuperMartijn642
 */
public class DurabilityTooltipConfig {

    public static final Supplier<TooltipStyle> tooltipStyle;
    public static final Supplier<Boolean> showTooltipHint;
    public static final Supplier<TooltipColorStyle> tooltipColorStyle;
    public static final Supplier<ChatFormatting> baseTooltipColor;
    public static final Supplier<Boolean> onlyVanillaTools;
    public static final Supplier<Boolean> showWhenFull;
    public static final Supplier<String> blackListedMods;

    static{
        IConfigBuilder builder = ConfigBuilders.newTomlConfig("durabilitytooltip", null, false);

        builder.push("Client");
        tooltipStyle = builder.dontSync().comment("What should be the style of the tooltip? 'numbers' means 'Durability: 30 / 100', 'text' means 'Durability: pristine/slight damaged/nearly broken', 'bar' means 'Durability: [███▒▒▒▒▒▒▒]'").define("tooltipStyle", TooltipStyle.NUMBERS);
        showTooltipHint = builder.dontSync().comment("Should the tooltip include the 'Durability:' hint?").define("showTooltipHint", true);
        tooltipColorStyle = builder.dontSync().comment("What colors should be used for the reactive part (numbers/text/bar characters) of the tooltip? 'base' means use the base color, 'gold' means always gold, 'varying' means green/orange/red depending on remaining durability.").define("tooltipColorStyle", TooltipColorStyle.VARYING);
        baseTooltipColor = builder.dontSync().comment("What should be the base text color of the tooltip?").define("baseTooltipColor", ChatFormatting.GRAY);
        onlyVanillaTools = builder.dontSync().comment("Should the durability tooltip only be shown on vanilla tools?").define("onlyVanillaTools", false);
        showWhenFull = builder.dontSync().comment("Should the durability tooltip be shown when a tool is not damaged?").define("showWhenFull", true);
        blackListedMods = builder.dontSync().comment("Which mods should be blacklisted? Items from blacklisted mods won't show the durability tooltip.").define("blackListedMods", "tconstruct,supplementaries", 0, 100);
        builder.pop();

        builder.build();
    }

    public static void init(){
        // Place this here so the class gets loaded
    }
}
