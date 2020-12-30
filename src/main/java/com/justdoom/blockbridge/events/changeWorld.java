package com.justdoom.blockbridge.events;

import com.justdoom.blockbridge.Blockbridge;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class changeWorld implements Listener {

    private final Blockbridge plugin;

    public changeWorld(Blockbridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void worldChange(PlayerChangedWorldEvent event){
        Player player = event.getPlayer();

        World to = event.getPlayer().getWorld();
        World from = event.getFrom();

        for(String key : plugin.getConfig().getConfigurationSection("worlds").getKeys(false)) {
            player.sendMessage(from.getName());
            player.sendMessage(to.getName());
            if (from.getName().equals(plugin.getConfig().getString("worlds." + key + ".world-name"))) {
                for(Player p : from.getPlayers()){
                    p.sendMessage(player.getDisplayName() + " has left");
                }
                System.out.println(player.getDisplayName() + " has left");
            } else if (to.getName().equals(plugin.getConfig().getString("worlds." + key + ".world-name"))) {
                for(Player p : from.getPlayers()){
                    p.sendMessage(player.getDisplayName() + " has joined");
                }
                player.sendMessage(player.getDisplayName() + " has joined");
                System.out.println(player.getDisplayName() + " has joined");
            }
        }
    }
}