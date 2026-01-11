package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class FrostNova extends Ability {
    public FrostNova() {
        super("FrostNova", "abilities.frost_nova", 10, Material.SNOWBALL);
    }

    @Override
    public void activate(Player player) {
        player.getNearbyEntities(5,5,5).forEach(e->{if(e instanceof Player p)p.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,60,1));});
    }
}
