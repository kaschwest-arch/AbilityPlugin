package com.example.abilities;

import com.example.abilities.command.AbilitiesCommand;
import com.example.abilities.listener.AbilityGUIListener;
import com.example.abilities.manager.AbilityManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AbilityPlugin extends JavaPlugin {

    private AbilityManager abilityManager;

    @Override
    public void onEnable() {
        abilityManager = new AbilityManager();

        getServer().getPluginManager().registerEvents(
                new AbilityGUIListener(this), this
        );

        getCommand("abilities").setExecutor(new AbilitiesCommand());

        getLogger().info("AbilityPlugin enabled!");
    }

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }
}
