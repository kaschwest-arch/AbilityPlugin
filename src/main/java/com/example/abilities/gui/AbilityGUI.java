package com.example.abilities.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;

import java.util.List;

public class AbilityGUI {

    public static void open(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "§5Abilities");

        gui.setItem(11, createItem(
                Material.BLAZE_POWDER,
                "§dMana Surge",
                List.of("§7Boosts mana regeneration")
        ));

        gui.setItem(13, createItem(
                Material.ENDER_PEARL,
                "§bBlink",
                List.of("§7Teleport forward")
        ));

        gui.setItem(15, createItem(
                Material.FIRE_CHARGE,
                "§cFire Burst",
                List.of("§7Launches fire")
        ));

        player.openInventory(gui);
    }

    private static ItemStack createItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }

        return item;
    }
}
