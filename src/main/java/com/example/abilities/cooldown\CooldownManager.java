package com.example.abilities.cooldown;

import com.example.abilities.ability.Ability;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    private static final Map<UUID, Map<Ability, Long>> cooldowns = new HashMap<>();

    public static boolean isOnCooldown(Player player, Ability ability) {
        return getRemainingCooldown(player, ability) > 0;
    }

    public static long getRemainingCooldown(Player player, Ability ability) {
        Map<Ability, Long> map = cooldowns.get(player.getUniqueId());
        if (map == null) return 0;

        Long endTime = map.get(ability);
        if (endTime == null) return 0;

        long remaining = endTime - System.currentTimeMillis();
        return Math.max(remaining, 0);
    }

    public static void setCooldown(Player player, Ability ability, int seconds) {
        cooldowns
                .computeIfAbsent(player.getUniqueId(), k -> new HashMap<>())
                .put(ability, System.currentTimeMillis() + (seconds * 1000L));
    }

    public static void clearCooldowns(Player player, Ability exclude) {
        Map<Ability, Long> map =
                cooldowns.computeIfAbsent(player.getUniqueId(), k -> new HashMap<>());

        map.keySet().removeIf(ability -> !ability.equals(exclude));
    }
}
