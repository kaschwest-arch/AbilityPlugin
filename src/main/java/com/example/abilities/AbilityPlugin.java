package com.example.abilities;

import com.example.abilities.gui.AbilityGUI;
import com.example.abilities.manager.AbilityManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AbilityPlugin extends JavaPlugin {

    private static AbilityPlugin instance;
    private AbilityManager abilityManager;
    private PlayerAbilityManager playerAbilityManager;

    @Override
    public void onEnable() {
        instance = this;
        abilityManager = new AbilityManager();

        getLogger().info("AbilityPlugin enabled!");
    }

    public static AbilityPlugin getInstance() {
        return instance;
    }

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }

    // ✅ THIS HANDLES /abilities
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("abilities")) {
            AbilityGUI.open(player);
            return true;
        }

        return false;
    }
}
