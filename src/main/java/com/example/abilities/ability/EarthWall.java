package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class EarthWall extends Ability {
    public EarthWall() {
        super("EarthWall", "abilities.earth_wall", 15, Material.DIRT);
    }

    @Override
    public void activate(Player player) {
        player.getWorld().spawnParticle(Particle.BLOCK, player.getLocation(), 40, Bukkit.createBlockData(Material.DIRT));
    }
}
