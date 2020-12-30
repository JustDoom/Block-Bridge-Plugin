package com.justdoom.blockbridge.commands;

import com.justdoom.blockbridge.Blockbridge;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class joinGameCommand implements CommandExecutor {

    private final Blockbridge plugin;

    public joinGameCommand(Blockbridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("joinblockbridge")){
            Player player = (Player) sender;

            List<String> worlds = new ArrayList<>();
            boolean worldsFull = true;
            for(String key : plugin.getConfig().getConfigurationSection("worlds").getKeys(false)) {
                World world = Bukkit.getWorld(plugin.getConfig().getString("worlds." + key + ".world-name"));
                if(!(world.getPlayers().size() >= plugin.getConfig().getInt("worlds." + key + ".max-players"))){
                    worldsFull = false;
                    player.sendMessage(world.getName());
                    Location location = new Location(world, 0, 70, 0);
                    player.teleport(location);
                    break;
                }
            }

            if(worldsFull){
                player.sendMessage("[EclipticMC] All servers are full, sorry about this inconvenience");
            }
        }
        return false;
    }
}