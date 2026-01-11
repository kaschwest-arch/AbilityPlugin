package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class LightningStrike extends Ability {
    public LightningStrike() {
        super("LightningStrike", "abilities.lightning_strike", 12, Material.TRIDENT);
    }

    @Override
    public void activate(Player player) {
        player.getWorld().strikeLightningEffect(player.getTargetBlockExact(15).getLocation());
    }
}
