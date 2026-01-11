package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ThunderStep extends Ability {

    public ThunderStep() {
        super(
            "Thunder Step",
            10,
            "Dash forward\nwith lightning speed.",
            Sound.ENTITY_LIGHTNING_BOLT_IMPACT,
            Particle.ELECTRIC_SPARK
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        Vector v = player.getLocation().getDirection().multiply(2.2);
        v.setY(0.25);
        player.setVelocity(v);
    }
}
