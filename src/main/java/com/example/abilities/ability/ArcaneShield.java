package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArcaneShield extends Ability {

    public ArcaneShield() {
        super(
            "Arcane Shield",
            20,
            "Reduces incoming damage\nfor a short time.",
            Sound.BLOCK_ENCHANTMENT_TABLE_USE,
            Particle.ENCHANT
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        player.addPotionEffect(new PotionEffect(
                PotionEffectType.RESISTANCE,
                100,
                1,
                true,
                false
        ));
    }
}
