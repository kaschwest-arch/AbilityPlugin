package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ThunderStep extends Ability {
    public ThunderStep() {
        super("ThunderStep", "abilities.thunder_step", 10, Material.GOLDEN_BOOTS);
    }

    @Override
    public void activate(Player player) {
        player.teleport(player.getLocation().add(0,0,3));
    }
}
