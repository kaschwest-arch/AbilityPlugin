package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class MeteorFall extends Ability {

    public MeteorFall() {
        super(
            "Meteor Fall",
            28,
            "Explodes target\narea.",
            Sound.ENTITY_GENERIC_EXPLODE,
            Particle.EXPLOSION
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);
        if (player.getTargetBlockExact(25) != null) {
            player.getWorld().createExplosion(
                    player.getTargetBlockExact(25).getLocation(),
                    3f,
                    false,
                    false,
                    player
            );
        }
    }
}
