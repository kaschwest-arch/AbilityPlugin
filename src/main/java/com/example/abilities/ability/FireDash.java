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
            "Dash forward\nleaving flames.",
            Sound.ENTITY_BLAZE_SHOOT,
            Particle.FLAME
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);
        Vector v = player.getLocation().getDirection().multiply(2.0);
        v.setY(0.2);
        player.setVelocity(v);
    }
}
