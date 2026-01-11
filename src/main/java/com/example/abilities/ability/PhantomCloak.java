package com.example.abilities.ability;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PhantomCloak extends Ability {
    public PhantomCloak() {
        super("PhantomCloak", "abilities.phantom_cloak", 22, Material.PHANTOM_MEMBRANE);
    }

    @Override
    public void activate(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,100,0));
    }
}
