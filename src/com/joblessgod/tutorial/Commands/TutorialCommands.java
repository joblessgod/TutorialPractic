package com.joblessgod.tutorial.Commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class TutorialCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command!");
            return true;
        }
        
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage("§e§l(!) §eYou have been healed!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
            player.sendMessage("§e§l(!) §eYou have been fed!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("farmtime")) {
            if (args.length >= 2) {
                try {
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);

                    for (int i = 0; i < amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                    player.sendMessage("§e§l(!) §eEntities spawned successfully!");

                } catch (IllegalArgumentException e) {
                    player.sendMessage("§c§l(!) §cThat's not a valid entity or amount!");
                }
                return true;
            } else {
                player.sendMessage("§c§l(!) §cUsage: /farmtime <mob> <amount>");
                return true;
            }
        }

        player.sendMessage("§c§l(!) §cUnknown command. Use /help for a list of commands.");
        return false;
    }
}
