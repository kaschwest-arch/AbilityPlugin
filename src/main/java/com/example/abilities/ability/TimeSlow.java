package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TimeSlow extends Ability {

    public TimeSlow() {
        super(
            "Time Slow",
            18,
            "Slows enemies\naround you.",
            Sound.BLOCK_AMETHYST_BLOCK_CHIME,
            Particle.PORTAL
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        for (Entity e : player.getNearbyEntities(6, 3, 6)) {
            if (e instanceof Player target && !target.equals(player)) {
                target.addPotionEffect(new PotionEffect(
                        PotionEffectType.SLOWNESS,
                        100,
                        3,
                        true,
                        false
                ));
            }
        }
    }
}
