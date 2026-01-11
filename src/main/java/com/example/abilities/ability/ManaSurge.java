package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ManaSurge extends Ability {
    public ManaSurge() {
        super("ManaSurge", "abilities.mana_surge", 30, Material.AMETHYST_SHARD);
    }

    @Override
    public void activate(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,80,1));
    }
}
