package com.example.abilities.manager;

import com.example.abilities.ability.*;
import java.util.ArrayList;
import java.util.List;

public class AbilityManager {

    private final List<Ability> abilities = new ArrayList<>();

    public AbilityManager() {
        registerAbilities();
    }

    private void registerAbilities() {
        abilities.add(new ArcaneShield());
        abilities.add(new Blink());
        abilities.add(new EarthWall());
        abilities.add(new FireDash());
        abilities.add(new FlameWave());
        abilities.add(new FrostNova());
        abilities.add(new HealingAura());
        abilities.add(new LightningStrike());
        abilities.add(new ManaSurge());
        abilities.add(new MeteorFall());
        abilities.add(new PhantomCloak());
        abilities.add(new ThunderStep());
        abilities.add(new TimeSlow());
        abilities.add(new VoidPull());
        abilities.add(new WindLeap());
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public Ability getAbilityByName(String name) {
        for (Ability ability : abilities) {
            if (ability.getName().equalsIgnoreCase(name)) {
                return ability;
            }
        }
        return null;
    }
}
