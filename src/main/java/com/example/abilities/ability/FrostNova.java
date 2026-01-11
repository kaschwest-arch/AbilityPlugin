package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FrostNova extends Ability {

    public FrostNova() {
        super(
            "Frost Nova",
            16,
            "Freezes enemies\naround you.",
            Sound.BLOCK_GLASS_BREAK,
            Particle.SNOWFLAKE
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        for (Entity e : player.getNearbyEntities(5, 3, 5)) {
            if (e instanceof Player target && !target.equals(player)) {
                target.addPotionEffect(new PotionEffect(
                        PotionEffectType.SLOWNESS,
                        80,
                        5,
                        true,
                        false
                ));
            }
        }
    }
}
