package de.mlg.near.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.mlg.near.main.Main;
import de.mlg.near.mlg.MLG;

public class PlayerDeath implements Listener {
    @EventHandler
    public void onDeath(org.bukkit.event.entity.PlayerDeathEvent e) {
        if (!Main.runningMLGs.isEmpty()) {
            if(Main.runningMLGs.containsKey((Player) e.getEntity())) {
                MLG mlg = Main.runningMLGs.get((Player) e.getEntity());
                e.setKeepInventory(true);
                e.setDeathMessage(null);
                mlg.failedMLG();
            }
        }
    }


}
