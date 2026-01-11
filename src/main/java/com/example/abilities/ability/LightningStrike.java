package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.LightningStrike;

public class LightningStrikeAbility extends Ability {

    public LightningStrikeAbility() {
        super(
            "Lightning Strike",
            15,
            "Calls down lightning\non your target.",
            Sound.ENTITY_LIGHTNING_BOLT_THUNDER,
            Particle.ELECTRIC_SPARK
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        if (player.getTargetBlockExact(25) == null) return;

        LightningStrike strike = player.getWorld().strikeLightning(
                player.getTargetBlockExact(25).getLocation()
        );
        strike.setCausingPlayer(player);
    }
}
