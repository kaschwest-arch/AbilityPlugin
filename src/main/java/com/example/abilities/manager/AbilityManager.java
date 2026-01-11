package com.example.abilities.manager;

import com.example.abilities.ability.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AbilityManager {

    private static final List<Ability> abilities = new ArrayList<>();

    public static void registerAbilities() {
        abilities.add(new ArcaneShield());
        abilities.add(new Blink());
        abilities.add(new ManaSurge());
        // add others here
    }

    public static List<Ability> getAbilities() {
        return abilities;
    }

    public static Ability getAbilityByName(String name) {
        for (Ability a : abilities) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    public static void activate(Player player, Ability ability) {
        ability.activate(player);
    }
}
