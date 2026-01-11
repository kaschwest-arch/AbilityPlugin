package com.example.abilities.listener;

import com.example.abilities.ability.*;
import com.example.abilities.manager.PlayerAbilityManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AbilityGUIListener implements Listener {

    private final PlayerAbilityManager playerAbilityManager;

    public AbilityGUIListener(PlayerAbilityManager manager) {
        this.playerAbilityManager = manager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;

        Inventory inv = event.getInventory();

        if (!event.getView().getTitle().equals("Select Your Ability")) return;

        event.setCancelled(true);

        ItemStack item = event.getCurrentItem();
        if (item == null || !item.hasItemMeta()) return;

        String name = ChatColor.stripColor(item.getItemMeta().getDisplayName());

        Ability ability = switch (name) {
            case "Fire Dash" -> new FireDash();
            case "Blink" -> new Blink();
            case "Frost Nova" -> new FrostNova();
            case "Thunder Step" -> new ThunderStep();
            case "Void Pull" -> new VoidPull();
            case "Wind Leap" -> new WindLeap();
            case "Healing Aura" -> new HealingAura();
            case "Arcane Shield" -> new ArcaneShield();
            default -> null;
        };

        if (ability == null) return;

        playerAbilityManager.setAbility(player.getUniqueId(), ability);

        player.sendMessage(ChatColor.GREEN + "You selected: " + ability.getName());
        player.closeInventory();
    }
}
