package com.example.abilities.listener;

import com.example.abilities.AbilityPlugin;
import com.example.abilities.manager.AbilityManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AbilityGUIListener implements Listener {

    private final AbilityManager abilityManager;

    public AbilityGUIListener(AbilityPlugin plugin) {
        this.abilityManager = plugin.getAbilityManager();
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (event.getCurrentItem() == null) return;
        if (!event.getView().getTitle().equals("§5Abilities")) return;

        event.setCancelled(true);

        ItemStack item = event.getCurrentItem();
        if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) return;

        String abilityName = item.getItemMeta()
                .getDisplayName()
                .replace("§", "");

        abilityManager.setAbility(player.getUniqueId(), abilityName);
        player.sendMessage("§aYou selected " + abilityName + "!");
        player.closeInventory();
    }
}
