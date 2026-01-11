package com.example.abilities.gui;

import com.example.abilities.AbilityPlugin;
import com.example.abilities.ability.Ability;
import com.example.abilities.manager.AbilityManager;
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

    private static final String TITLE = ChatColor.DARK_PURPLE + "Select Your Ability";

    public static void open(Player player) {
        AbilityManager manager = AbilityPlugin.getInstance().getAbilityManager();
        List<Ability> abilities = manager.getAbilities();

        Inventory inventory = Bukkit.createInventory(null, 27, TITLE);

        int slot = 0;
        for (Ability ability : abilities) {
            ItemStack item = new ItemStack(Material.NETHER_STAR);
            ItemMeta meta = item.getItemMeta();

            if (meta == null) continue;

            meta.setDisplayName(ChatColor.LIGHT_PURPLE + ability.getName());

            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + ability.getDescription());
            lore.add("");
            lore.add(ChatColor.YELLOW + "Cooldown: " + ability.getCooldown() + "s");
            lore.add(ChatColor.GREEN + "Click to select");

            meta.setLore(lore);
            item.setItemMeta(meta);

            inventory.setItem(slot++, item);
        }

        player.openInventory(inventory);
    }
}
