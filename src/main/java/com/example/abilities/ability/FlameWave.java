package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class FlameWave extends Ability {
    public FlameWave() {
        super("FlameWave", "abilities.flame_wave", 9, Material.FIRE_CHARGE);
    }

    @Override
    public void activate(Player player) {
        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 80);
    }
}
