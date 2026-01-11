package com.example.abilities.manager;

import com.example.abilities.ability.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.*;

public class AbilityManager implements Listener {

    private final Map<UUID, Ability> selected = new HashMap<>();
    private final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();

    public void setSelected(Player p, Ability a) {
        selected.put(p.getUniqueId(), a);
        p.sendActionBar("§aSelected: " + a.getName());
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
        Player p = e.getPlayer();

        if (!p.hasPermission("abilities.use")) return;

        Ability a = selected.get(p.getUniqueId());
        if (a == null) {
            p.sendActionBar("§eSelect an ability first (/abilities)");
            return;
        }

        if (!p.hasPermission(a.getPermission()) && !p.hasPermission("abilities.*")) {
            p.sendActionBar("§cYou do not have this ability");
            return;
        }

        cooldowns.putIfAbsent(p.getUniqueId(), new HashMap<>());
        Map<String, Long> map = cooldowns.get(p.getUniqueId());

        long now = System.currentTimeMillis();
        long end = map.getOrDefault(a.getName(), 0L);

        if (end > now) {
            p.sendActionBar("§eCooldown: " + ((end-now)/1000+1) + "s");
            return;
        }

        a.activate(p);
        map.put(a.getName(), now + a.getCooldown()*1000L);
    }

    public List<Ability> getAbilities() {
        return List.of(
            new FireDash(),
            new Blink(),
            new LightningStrike(),
            new FrostNova(),
            new WindLeap(),
            new EarthWall(),
            new VoidPull(),
            new FlameWave(),
            new ArcaneShield(),
            new HealingAura(),
            new ThunderStep(),
            new TimeSlow(),
            new MeteorFall(),
            new PhantomCloak(),
            new ManaSurge()
        );
    }
}
