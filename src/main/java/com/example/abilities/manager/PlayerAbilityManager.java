package com.example.abilities.manager;

import com.example.abilities.ability.Ability;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerAbilityManager {

    private final Map<UUID, Ability> selectedAbilities = new HashMap<>();

    public void setAbility(UUID uuid, Ability ability) {
        selectedAbilities.put(uuid, ability);
    }

    public Ability getAbility(UUID uuid) {
        return selectedAbilities.get(uuid);
    }

    public boolean hasAbility(UUID uuid) {
        return selectedAbilities.containsKey(uuid);
    }
}
