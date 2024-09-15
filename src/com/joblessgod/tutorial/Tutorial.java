package com.joblessgod.tutorial;

import com.joblessgod.tutorial.Commands.TutorialCommands;
import com.joblessgod.tutorial.Events.TutorialEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        TutorialCommands commands = new TutorialCommands();
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"[Tutorial] plugin has enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED+"[Tutorial] plugin has disabled!");
    }
}
