package com.justdoom.blockbridge;

import com.justdoom.blockbridge.commands.joinGameCommand;
import com.justdoom.blockbridge.commands.reloadConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Blockbridge extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.getCommand("joinblockbridge").setExecutor(new joinGameCommand(this));
        this.getCommand("blockbridgereload").setExecutor(new reloadConfig(this));
        //Bukkit.getPluginManager().registerEvents(new joinEvent(this), this);
    }

    @Override
    public void onDisable() {
        
    }
    //uhhh
}
