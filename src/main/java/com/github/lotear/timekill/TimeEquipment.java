package com.github.lotear.timekill;

import org.bukkit.inventory.ItemStack;

public class TimeEquipment
{
    private final ItemStack sword, bow, helmet, chest, leg, boots;

    private final int tick;

    public TimeEquipment(int tick, ItemStack sword, ItemStack bow, ItemStack helmet, ItemStack chest, ItemStack leg, ItemStack boots)
    {
        this.sword = sword;
        this.helmet = helmet;
        this.chest = chest;
        this.leg = leg;
        this.boots = boots;
        this.bow = bow;
        this.tick = tick;
    }

    public ItemStack getSword()
    {
        return sword;
    }

    public ItemStack getBow()
    {
        return bow;
    }

    public ItemStack getHelmet()
    {
        return helmet;
    }

    public ItemStack getChest()
    {
        return chest;
    }

    public ItemStack getLeg()
    {
        return leg;
    }

    public ItemStack getBoots()
    {
        return boots;
    }

    public int getTick()
    {
        return tick;
    }
}
