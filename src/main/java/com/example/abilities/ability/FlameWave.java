package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class FlameWave extends Ability {

    public FlameWave() {
        super(
            "Flame Wave",
            14,
            "Releases a wave\nof fire forward.",
            Sound.ITEM_FIRECHARGE_USE,
            Particle.FLAME
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        for (Entity e : player.getNearbyEntities(6, 2, 6)) {
            if (e instanceof Player target && !target.equals(player)) {
                target.setFireTicks(60);
                target.damage(4, player);
            }
        }
    }
}
