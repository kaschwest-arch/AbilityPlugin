package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public abstract class Ability {

    private final String name;
    private final int cooldownSeconds;
    private final String description;
    private final Sound sound;
    private final Particle particle;

    public Ability(String name, int cooldownSeconds, String description,
                   Sound sound, Particle particle) {
        this.name = name;
        this.cooldownSeconds = cooldownSeconds;
        this.description = description;
        this.sound = sound;
        this.particle = particle;
    }

    public String getName() {
        return name;
    }

    public int getCooldownSeconds() {
        return cooldownSeconds;
    }

    public String getDescription() {
        return description;
    }

    public void playEffects(Player player) {
        player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
        player.getWorld().spawnParticle(
                particle,
                player.getLocation().add(0, 1, 0),
                30,
                0.5, 0.5, 0.5,
                0.05
        );
    }

    public abstract void activate(Player player);
}
