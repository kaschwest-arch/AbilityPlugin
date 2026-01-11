package com.example.abilities.gui;

import com.example.abilities.ability.Ability;
import com.example.abilities.manager.AbilityManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AbilityGUI implements Listener {

    private final AbilityManager manager;

    public AbilityGUI(AbilityManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (!e.getMessage().equalsIgnoreCase("/abilities")) return;
        e.setCancelled(true);

        Player p = e.getPlayer();
        Inventory inv = Bukkit.createInventory(null, 27, "Select Ability");

        for (Ability a : manager.getAbilities()) {
            if (!p.hasPermission(a.getPermission()) && !p.hasPermission("abilities.*")) continue;
            ItemStack item = new ItemStack(a.getIcon());
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§a" + a.getName());
            item.setItemMeta(meta);
            inv.addItem(item);
        }

        p.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals("Select Ability")) return;
        e.setCancelled(true);

        if (!(e.getWhoClicked() instanceof Player p)) return;
        ItemStack item = e.getCurrentItem();
        if (item == null) return;

        for (Ability a : manager.getAbilities()) {
            if (a.getIcon() == item.getType()) {
                manager.setSelected(p, a);
                p.closeInventory();
                break;
            }
        }
    }
}
