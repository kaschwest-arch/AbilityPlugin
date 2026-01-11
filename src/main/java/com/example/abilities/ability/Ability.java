package com.example.abilities.ability;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public abstract class Ability {
    private final String name;
    private final String permission;
    private final int cooldown;
    private final Material icon;

    public Ability(String name, String permission, int cooldown, Material icon) {
        this.name = name;
        this.permission = permission;
        this.cooldown = cooldown;
        this.icon = icon;
    }

    public String getName() { return name; }
    public String getPermission() { return permission; }
    public int getCooldown() { return cooldown; }
    public Material getIcon() { return icon; }

    public abstract void activate(Player player);
}
