package de.mlg.near.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import de.mlg.near.main.Main;

public class HelpCommand {
    public static void printHelp(Player p) {
        p.sendMessage(Main.prefix + ChatColor.RED + "Commands:");
        p.sendMessage(Main.prefix + ChatColor.YELLOW + "/mlg " + ChatColor.GREEN + "Löst denn MLG Water aus");
    }


}
