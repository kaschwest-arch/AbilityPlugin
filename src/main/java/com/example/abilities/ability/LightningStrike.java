package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LightningStrike extends Ability {

    public LightningStrike() {
        super(
            "Lightning Strike",
            18,
            "Calls lightning\non target.",
            Sound.ENTITY_LIGHTNING_BOLT_THUNDER,
            Particle.ELECTRIC_SPARK
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);
        if (player.getTargetBlockExact(30) != null) {
            player.getWorld().strikeLightningEffect(
                    player.getTargetBlockExact(30).getLocation()
            );
        }
    }
}
