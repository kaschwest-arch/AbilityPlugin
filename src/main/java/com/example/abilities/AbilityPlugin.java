package com.example.abilities;

import com.example.abilities.manager.PlayerAbilityManager;
import com.example.abilities.command.AbilitiesCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AbilityPlugin extends JavaPlugin {

    private PlayerAbilityManager abilityManager;

    @Override
    public void onEnable() {
        abilityManager = new PlayerAbilityManager();

        Bukkit.getPluginManager().registerEvents(
                new AbilityGUIListener(abilityManager),
                this
        );

        getLogger().info("AbilityPlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AbilityPlugin disabled!");
    }
}
