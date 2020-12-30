package com.justdoom.blockbridge.commands;

import com.justdoom.blockbridge.Blockbridge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadConfig implements CommandExecutor {

    private final Blockbridge plugin;

    public reloadConfig(Blockbridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("blockbridgereload")) {
            Player player = (Player) sender;
            plugin.reloadConfig();
            player.sendMessage("Config Reloaded");
        }

        return false;
    }
}
