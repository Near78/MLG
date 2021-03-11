package de.mlg.near.utils;

import org.bukkit.entity.Player;

import de.mlg.near.main.Main;

public class Erroru {
    public static void printInvalidArgsError(Player p, String correctArgs) {
        p.sendMessage(Main.prefix + "§c Deine Eingabe war Falsch.Bitte benutze diesen Befehl" + correctArgs);
        p.sendMessage(Main.prefix + "Wenn du Hilfe brauchst mach bitte /mlg help");
    }

}
