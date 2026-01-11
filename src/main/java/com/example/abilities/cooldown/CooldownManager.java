package com.example.abilities.cooldown;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    private static final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();

    public static boolean isOnCooldown(UUID playerId, String abilityName) {
        if (!cooldowns.containsKey(playerId)) return false;
        Map<String, Long> playerCooldowns = cooldowns.get(playerId);
        if (!playerCooldowns.containsKey(abilityName)) return false;

        return playerCooldowns.get(abilityName) > System.currentTimeMillis();
    }

    public static long getRemaining(UUID playerId, String abilityName) {
        if (!isOnCooldown(playerId, abilityName)) return 0;
        return cooldowns.get(playerId).get(abilityName) - System.currentTimeMillis();
    }

    public static void setCooldown(UUID playerId, String abilityName, int seconds) {
        cooldowns
            .computeIfAbsent(playerId, k -> new HashMap<>())
            .put(abilityName, System.currentTimeMillis() + (seconds * 1000L));
    }
}
