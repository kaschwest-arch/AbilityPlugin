package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class EarthWall extends Ability {

    public EarthWall() {
        super(
            "Earth Wall",
            18,
            "Pushes enemies back\nwith earth energy.",
            Sound.BLOCK_STONE_PLACE,
            Particle.BLOCK
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        for (Entity e : player.getNearbyEntities(4, 2, 4)) {
            if (e instanceof Player target && !target.equals(player)) {
                target.setVelocity(
                        target.getLocation().toVector()
                                .subtract(player.getLocation().toVector())
                                .normalize()
                                .multiply(1.2)
                );
            }
        }
    }
}
