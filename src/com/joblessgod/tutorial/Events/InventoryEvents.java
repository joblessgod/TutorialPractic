package com.joblessgod.tutorial.Events;

import com.joblessgod.tutorial.Inventories.SelectionScreen;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InventoryEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) {
            return;
        }
        if (event.getClickedInventory().getHolder() instanceof SelectionScreen) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();


                if (event.getCurrentItem() == null) {
                    return;
                }
                if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                    player.sendMessage(ChatColor.GREEN + "You have selected the ACCEPT Button");
                    if (event.isLeftClick()) {
                        player.giveExp(1000);
                    player.closeInventory();
                    }
                } else if (event.getSlot() == 4) {
                    player.sendMessage(ChatColor.AQUA + "Please make a selection... I don't have all day.");
                } else if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                    if (event.getCurrentItem() == null) {
                        return;
                    }
                    if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                        player.sendMessage(ChatColor.RED + "You have selected the DENY Button");
                        if (event.isLeftClick()) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10*20, 10));
                        player.closeInventory();
                        }
                    }
                }

    }
}
}
