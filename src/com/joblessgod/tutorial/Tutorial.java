package com.joblessgod.tutorial;

import com.joblessgod.tutorial.Commands.SelectPanel;
import com.joblessgod.tutorial.Commands.TutorialCommands;
import com.joblessgod.tutorial.Events.InventoryEvents;
import com.joblessgod.tutorial.Events.TutorialEvents;
import com.joblessgod.tutorial.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        TutorialCommands commands = new TutorialCommands();
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getCommand("givewand").setExecutor(commands);
        getCommand("choose").setExecutor(new SelectPanel());
        ItemManager.init();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"[Tutorial] plugin has enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED+"[Tutorial] plugin has disabled!");
    }
}
