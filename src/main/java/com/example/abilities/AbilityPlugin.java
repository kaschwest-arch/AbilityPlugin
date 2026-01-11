package com.example.abilities;

import com.example.abilities.gui.AbilityGUI;
import com.example.abilities.listener.AbilityGUIListener;
import com.example.abilities.manager.AbilityManager;
import com.example.abilities.manager.PlayerAbilityManager;
import com.example.abilities.cooldown.CooldownManager;

import org.bukkit.plugin.java.JavaPlugin;

public class AbilityPlugin extends JavaPlugin {

    private static AbilityPlugin instance;

    private AbilityManager abilityManager;
    private PlayerAbilityManager playerAbilityManager;
    private CooldownManager cooldownManager;

    @Override
    public void onEnable() {
        instance = this;

        // Managers
        abilityManager = new AbilityManager();
        cooldownManager = new CooldownManager();
        playerAbilityManager = new PlayerAbilityManager();

        // Register abilities
        abilityManager.registerAbilities();

        // Register GUI listener
        getServer().getPluginManager().registerEvents(
                new AbilityGUIListener(playerAbilityManager),
                this
        );

        getLogger().info("AbilityPlugin enabled successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AbilityPlugin disabled.");
    }

    public static AbilityPlugin getInstance() {
        return instance;
    }

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }

    public PlayerAbilityManager getPlayerAbilityManager() {
        return playerAbilityManager;
    }

    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }
}
