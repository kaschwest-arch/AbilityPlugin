package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class HealingAura extends Ability {

    public HealingAura() {
        super(
            "Healing Aura",
            25,
            "Restores health\nover time.",
            Sound.BLOCK_BEACON_ACTIVATE,
            Particle.HEART
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        double newHealth = Math.min(
                player.getHealth() + 6.0,
                player.getMaxHealth()
        );
        player.setHealth(newHealth);
    }
}
