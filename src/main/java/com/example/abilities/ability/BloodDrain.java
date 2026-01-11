package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class BloodDrain extends Ability {
    public BloodDrain() {
        super("BloodDrain", "abilities.blood_drain", 14, Material.REDSTONE);
    }

    @Override
    public void activate(Player player) {
        player.setHealth(Math.min(player.getMaxHealth(), player.getHealth()+2));
    }
}
