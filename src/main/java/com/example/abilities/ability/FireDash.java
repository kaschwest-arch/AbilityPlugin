package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class FireDash extends Ability {

    public FireDash() {
        super(
            "Fire Dash",
            8,
            "Launches you forward\nin a burst of fire.",
            Sound.ENTITY_BLAZE_SHOOT,
            Particle.FLAME
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        Vector direction = player.getLocation().getDirection().normalize().multiply(1.8);
        direction.setY(0.35);
        player.setVelocity(direction);
    }
}
