package com.github.lotear.timekill;

import org.bukkit.configuration.ConfigurationSection;

public class Config
{
    public static int initTick;

    public static int bonusTick;

    public static void load(ConfigurationSection config)
    {
        initTick = config.getInt("init-tick");
        bonusTick = config.getInt("bonus-tick");
    }
}
