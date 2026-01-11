package com.example.abilities;

import com.example.abilities.gui.AbilityGUI;
import com.example.abilities.listener.AbilityGUIListener;
import com.example.abilities.manager.PlayerAbilityManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AbilityPlugin extends JavaPlugin {

    private static AbilityPlugin instance;
    private PlayerAbilityManager playerAbilityManager;
    private AbilityGUI abilityGUI;

    @Override
    public void onEnable() {
        instance = this;

        // Managers
        playerAbilityManager = new PlayerAbilityManager();
        abilityGUI = new AbilityGUI();

        // Register listeners
        getServer().getPluginManager().registerEvents(
                new AbilityGUIListener(playerAbilityManager),
                this
        );

        getLogger().info("AbilityPlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AbilityPlugin disabled!");
    }

    public static AbilityPlugin getInstance() {
        return instance;
    }

    public PlayerAbilityManager getPlayerAbilityManager() {
        return playerAbilityManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("abilities")) {
            abilityGUI.open(player);
            return true;
        }

        return false;
    }
}
