package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class MeteorFall extends Ability {

    public MeteorFall() {
        super(
            "Meteor Fall",
            25,
            "Summons a meteor\nfrom the sky.",
            Sound.ENTITY_GENERIC_EXPLODE,
            Particle.EXPLOSION
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        if (player.getTargetBlockExact(30) == null) return;

        player.getWorld().createExplosion(
                player.getTargetBlockExact(30).getLocation(),
                3.0f,
                false,
                false,
                player
        );
    }
}
