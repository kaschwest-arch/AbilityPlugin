package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class FireDash extends Ability {
    public FireDash() {
        super("FireDash", "abilities.fire_dash", 6, Material.BLAZE_POWDER);
    }

    @Override
    public void activate(Player player) {
        player.setVelocity(player.getLocation().getDirection().multiply(1.6));
    }
}
