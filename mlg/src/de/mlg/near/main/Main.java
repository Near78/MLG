package de.mlg.near.main;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.mlg.near.commands.MLGCommand;
import de.mlg.near.listeners.EntityDamage;
import de.mlg.near.listeners.PlayerDeath;
import de.mlg.near.mlg.MLG;

public class Main extends JavaPlugin {
    public static String prefix = "§a[§aMLG] ";
    public static HashMap<Player, MLG> runningMLGs = new HashMap<Player, MLG>();

    @Override
    public void onEnable() {

        System.out.println("MLG Plugin Enabled");
        commandRegistration();
        eventRegistration();
    }

    private void commandRegistration() {
        getCommand("mlg").setExecutor(new MLGCommand());
    }

    private void eventRegistration() {
        getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
    }


}
