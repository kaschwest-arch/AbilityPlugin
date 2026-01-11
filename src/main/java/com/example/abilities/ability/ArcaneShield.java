package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ArcaneShield extends Ability {
    public ArcaneShield() {
        super("ArcaneShield", "abilities.arcane_shield", 18, Material.SHIELD);
    }

    @Override
    public void activate(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,80,0));
    }
}
