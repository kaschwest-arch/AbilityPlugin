package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class EarthWall extends Ability {

    public EarthWall() {
        super(
            "Earth Wall",
            20,
            "Raises a protective\nwall of earth.",
            Sound.BLOCK_STONE_PLACE,
            Particle.BLOCK
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);
        // Visual / defensive ability placeholder
    }
}
