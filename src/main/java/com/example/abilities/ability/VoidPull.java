package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class VoidPull extends Ability {
    public VoidPull() {
        super("VoidPull", "abilities.void_pull", 12, Material.OBSIDIAN);
    }

    @Override
    public void activate(Player player) {
        player.getNearbyEntities(4,4,4).forEach(e->e.setVelocity(player.getLocation().toVector().subtract(e.getLocation().toVector()).normalize()));
    }
}
