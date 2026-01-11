package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Blink extends Ability {

    public Blink() {
        super(
            "Blink",
            6,
            "Teleport a short\ndistance forward.",
            Sound.ENTITY_ENDERMAN_TELEPORT,
            Particle.PORTAL
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);
        player.teleport(player.getLocation().add(
                player.getLocation().getDirection().multiply(6)
        ));
    }
}
