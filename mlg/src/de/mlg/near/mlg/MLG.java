package de.mlg.near.mlg;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import de.mlg.near.main.Main;
import de.mlg.near.utils.GeneralUtils;

public class MLG {
    public String[] allowedMLGTypes = new String[]{"Wasser", "Water"};
    public int maxMlgHeight = 1000;

    private Player p;
    private boolean running = false;
    private int height = 20;
    private Material item;

    public Player getPlayer() {
        return p;
    }

    public void setPlayer(Player p) {
        this.p = p;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setItem(Material item) {
        this.item = item;
    }

    public void resetVariables() {
        this.height = 20;
    }

    public void handleMLG() {
        resetVariables();
        running = true;

        p.sendMessage(Main.prefix + "Dein Training beginnt nun...");
        triggerMLG();
    }

    private void triggerMLG() {
        Location currentloc = p.getLocation();

        int x = currentloc.getBlockX();
        int y = currentloc.getBlockY() + height;
        int z = currentloc.getBlockZ();
        float yaw = currentloc.getYaw();
        float pitch = currentloc.getPitch();
        World world = currentloc.getWorld();
        Location mlgLocation = new Location(world, x, y, z, yaw, pitch);

        handleMLGItem();

        p.teleport(mlgLocation);
        triggerNewMLG();
    }

    public void successfulMLG() {
        p.sendMessage(Main.prefix + "Du hast den MLG aus §c" + height + " §eBlöcken§7 erfolgreich geschafft!");
        if (height < maxMlgHeight) {
            height += 10;
        }
    }

    public void failedMLG() {
        if (height > 20) {
            p.sendMessage(Main.prefix + "Leider hast du den MLG §cnicht geschafft. §7Dein Score war: §a" + (height - 10) + " Blöcke§7!");
        } else {
            p.sendMessage(Main.prefix + "Leider hast du den MLG §cnicht geschafft.");
        }
        height = 20;
        running = false;
        removeMLGItem();
        Main.runningMLGs.remove(p, this);
    }

    public void handleMLGItem() {
        if(!p.getInventory().contains(new ItemStack(Material.WATER_BUCKET))) {
            PlayerInventory inv = p.getInventory();
            inv.addItem(new ItemStack(item));
        }
    }

    private void removeMLGItem() {
        PlayerInventory inv = p.getInventory();
        inv.removeItem(new ItemStack(item));
        p.updateInventory();
    }

    private void triggerNewMLG() {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
            @Override
            public void run() {
                if (running) {
                    successfulMLG();
                    triggerMLG();
                }
            }
        }, GeneralUtils.calcFallSeconds(height) * 20);
    }


}
