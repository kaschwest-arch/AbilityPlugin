package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class WindLeap extends Ability {

    public WindLeap() {
        super(
            "Wind Leap",
            7,
            "Launches you high\ninto the air.",
            Sound.ENTITY_PHANTOM_FLAP,
            Particle.CLOUD
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        player.setVelocity(new Vector(0, 1.1, 0));
    }
}
