package com.joblessgod.tutorial.Commands;

import com.joblessgod.tutorial.Inventories.SelectionScreen;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SelectPanel implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can uses this commands!");
            return true;
        }



        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("choose")){
            SelectionScreen gui = new SelectionScreen();
            player.openInventory(gui.getInventory());
            player.sendMessage(ChatColor.AQUA+ "Please make a selection");
        }







        return true;
    }
}
