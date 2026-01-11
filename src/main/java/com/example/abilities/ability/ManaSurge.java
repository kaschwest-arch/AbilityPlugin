package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ManaSurge extends Ability {

    public ManaSurge() {
        super(
            "Mana Surge",
            30,
            "Instantly refreshes\nability cooldowns.",
            Sound.BLOCK_BEACON_POWER_SELECT,
            Particle.END_ROD
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);
        // Hook into cooldown manager later
    }
}
