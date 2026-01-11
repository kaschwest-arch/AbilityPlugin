package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class VoidPull extends Ability {

    public VoidPull() {
        super(
            "Void Pull",
            16,
            "Pulls enemies\ntoward you.",
            Sound.ENTITY_ENDERMAN_SCREAM,
            Particle.PORTAL
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        for (Entity e : player.getNearbyEntities(6, 3, 6)) {
            if (e instanceof Player target && !target.equals(player)) {
                Vector pull = player.getLocation().toVector()
                        .subtract(target.getLocation().toVector())
                        .normalize()
                        .multiply(0.9);
                target.setVelocity(pull);
            }
        }
    }
}
