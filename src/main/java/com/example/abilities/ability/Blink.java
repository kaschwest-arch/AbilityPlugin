package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Blink extends Ability {

    public Blink() {
        super(
            "Blink",
            10,
            "Teleports you a short\ndistance forward.",
            Sound.ENTITY_ENDERMAN_TELEPORT,
            Particle.PORTAL
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        Vector direction = player.getLocation().getDirection().normalize().multiply(6);
        player.teleport(player.getLocation().add(direction));
    }
}
