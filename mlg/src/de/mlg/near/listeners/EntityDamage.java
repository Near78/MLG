package de.mlg.near.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.mlg.near.main.Main;
import de.mlg.near.mlg.MLG;

public class EntityDamage implements Listener {
    @EventHandler
    public void onDamage(org.bukkit.event.entity.EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            if (!Main.runningMLGs.isEmpty()) {
                if(Main.runningMLGs.containsKey((Player) e.getEntity())) {
                    MLG mlg = Main.runningMLGs.get((Player) e.getEntity());
                    mlg.getPlayer().setHealth(20);
                    mlg.failedMLG();
                }
            }
        }
    }


}
