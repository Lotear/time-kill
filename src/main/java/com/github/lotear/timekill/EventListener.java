package com.github.lotear.timekill;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class EventListener implements Listener
{
    private final TimeKillProcess timeKillProcess;

    public EventListener(TimeKillProcess timeKillProcess)
    {
        this.timeKillProcess = timeKillProcess;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev)
    {
        Player p = ev.getPlayer();
        timeKillProcess.onJoin(p);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent ev)
    {
        Player p = ev.getPlayer();
        timeKillProcess.onQuit(p);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent ev)
    {
        Player victim = ev.getEntity();
        Player killer = victim.getKiller();

        if (killer != null)
        {
            TimePlayer timekiller = timeKillProcess.getTimePlayer(killer);
            TimePlayer timevictim = timeKillProcess.getTimePlayer(victim);
            if (timekiller != null && timevictim != null && timekiller.isAlive() && timevictim.isAlive())
            {
                timevictim.onDeath(timekiller);
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event)
    {
        Player player = event.getPlayer();
        TimePlayer timePlayer = timeKillProcess.getTimePlayer(player);

        if (timePlayer != null)
            event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        TimePlayer timePlayer = timeKillProcess.getTimePlayer(player);

        if (timePlayer != null)
            event.setCancelled(true);
    }

    @EventHandler
    public void onInventorySwap(PlayerSwapHandItemsEvent event)
    {
        Player player = event.getPlayer();
        TimePlayer timePlayer = timeKillProcess.getTimePlayer(player);

        if (timePlayer != null)
            event.setCancelled(true);
    }
}
