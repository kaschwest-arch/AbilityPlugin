package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ShadowBlink extends Ability {
    public ShadowBlink() {
        super("ShadowBlink", "abilities.shadow_blink", 8, Material.ENDER_PEARL);
    }

    @Override
    public void activate(Player player) {
        player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(4)));
    }
}
