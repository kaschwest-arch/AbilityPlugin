package com.example.abilities;

import com.example.abilities.manager.AbilityManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AbilityPlugin extends JavaPlugin {

    private static AbilityPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        AbilityManager.registerAbilities();
        getLogger().info("AbilityPlugin enabled!");
    }

    public static AbilityPlugin getInstance() {
        return instance;
    }
}
