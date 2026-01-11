package com.example.abilities.gui;

import com.example.abilities.ability.Ability;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AbilityGUI {

    public static Inventory create(Player player, List<Ability> abilities) {
        Inventory inv = Bukkit.createInventory(null, 27, "§bSelect Ability");

        for (Ability ability : abilities) {
            ItemStack item = new ItemStack(Material.NETHER_STAR);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName("§e" + ability.getName());

            List<String> lore = new ArrayList<>();
            lore.add("§7" + ability.getDescription());
            lore.add("");
            lore.add("§eCooldown: §c" + ability.getCooldownSeconds() + "s");
            lore.add("§bActivate: §fOffhand (F)");

            meta.setLore(lore);
            item.setItemMeta(meta);

            inv.addItem(item);
        }

        return inv;
    }
}
