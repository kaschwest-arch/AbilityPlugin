package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class WindLeap extends Ability {
    public WindLeap() {
        super("WindLeap", "abilities.wind_leap", 5, Material.FEATHER);
    }

    @Override
    public void activate(Player player) {
        player.setVelocity(new Vector(0,1.2,0));
    }
}
