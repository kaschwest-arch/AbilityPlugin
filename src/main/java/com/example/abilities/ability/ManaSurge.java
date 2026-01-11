package com.example.abilities.ability;

import com.example.abilities.cooldown.CooldownManager;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ManaSurge extends Ability {

    public ManaSurge() {
        super(
            "Mana Surge",
            30,
            "Instantly refreshes\nall ability cooldowns.",
            Sound.BLOCK_BEACON_POWER_SELECT,
            Particle.END_ROD
        );
    }

    @Override
    public v
