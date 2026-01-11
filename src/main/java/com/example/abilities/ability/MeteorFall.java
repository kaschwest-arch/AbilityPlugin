package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class MeteorFall extends Ability {
    public MeteorFall() {
        super("MeteorFall", "abilities.meteor_fall", 25, Material.MAGMA_BLOCK);
    }

    @Override
    public void activate(Player player) {
        player.getWorld().spawnParticle(Particle.EXPLOSION, player.getLocation().add(0,8,0), 5);
    }
}
