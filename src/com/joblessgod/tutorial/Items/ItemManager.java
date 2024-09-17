package com.joblessgod.tutorial.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack wand;

    public static void init() {
        createWand();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Stick of Truth");
        List<String> lore = new ArrayList<>();
        lore.add("§7This powerfull artifact is a relic of");
        lore.add("§7Minecraft Ancient History!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;

        // Shaped Reciepe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
        // sr.shape("XXX","XXX","XXX");
        sr.shape("B  "," S "," S ");
        sr.setIngredient('B', Material.BLAZE_POWDER);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        // shapeless reciepe
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("wand_shapeless"), item);
        slr.addIngredient(2, Material.BLAZE_POWDER);
        slr.addIngredient(1, Material.DIAMOND);
        Bukkit.getServer().addRecipe(slr);

        // Furnace Recipe
//        NamespacedKey furnaceKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin("TutoralPractice"), "wand_smelt");
//
//        FurnaceRecipe smelt = new FurnaceRecipe(furnaceKey, item, Material.EMERALD, 0.1f, 10 * 20);
//        Bukkit.getServer().addRecipe(smelt);


    }
}
