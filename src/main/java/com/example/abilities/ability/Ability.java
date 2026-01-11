package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public abstract class Ability {

    private final String name;
    private final int cooldown;
    private final String description;
    private final Sound sound;
    private final Particle particle;

    public Ability(String name, int cooldown, String description, Sound sound, Particle particle) {
        this.name = name;
        this.cooldown = cooldown;
        this.description = description;
        this.sound = sound;
        this.particle = particle;
    }

    public abstract void activate(Player player);

    public String getName() {
        return name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public String getDescription() {
        return description;
    }

    protected void playEffects(Player player) {
        player.playSound(player.getLocation(), sound, 1f, 1f);
        player.getWorld().spawnParticle(
            particle,
            player.getLocation().add(0, 1, 0),
            30,
            0.5, 0.5, 0.5
        );
    }
}
