package com.example.abilities.listener;

import com.example.abilities.manager.PlayerAbilityManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AbilityGUIListener implements Listener {

    private final PlayerAbilityManager abilityManager;

    public AbilityGUIListener(PlayerAbilityManager abilityManager) {
        this.abilityManager = abilityManager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (event.getView().getTitle() == null) return;
        if (!event.getView().getTitle().equals("Select Your Ability")) return;

        event.setCancelled(true);

        ItemStack item = event.getCurrentItem();
        if (item == null || item.getType() == Material.AIR) return;

        switch (item.getType()) {
            case BLAZE_POWDER -> {
                abilityManager.setAbility(player, "ManaSurge");
                player.sendMessage("§aYou selected Mana Surge!");
                player.closeInventory();
            }
        }
    }
}
