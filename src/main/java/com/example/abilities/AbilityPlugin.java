package com.example.abilities;

import com.example.abilities.manager.AbilityManager;
import com.example.abilities.gui.AbilityGUI;
import org.bukkit.plugin.java.JavaPlugin;

public class AbilityPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        AbilityManager manager = new AbilityManager();
        getServer().getPluginManager().registerEvents(manager, this);
        getServer().getPluginManager().registerEvents(new AbilityGUI(manager), this);
    }
}
