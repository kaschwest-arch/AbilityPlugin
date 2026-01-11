package com.example.abilities.ability;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PhantomCloak extends Ability {

    public PhantomCloak() {
        super(
            "Phantom Cloak",
            22,
            "Turns you invisible\nbriefly.",
            Sound.ENTITY_PHANTOM_FLAP,
            Particle.SMOKE
        );
    }

    @Override
    public void activate(Player player) {
        playEffects(player);

        player.addPotionEffect(new PotionEffect(
                PotionEffectType.INVISIBILITY,
                120,
                0,
                true,
                false
        ));
    }
}
