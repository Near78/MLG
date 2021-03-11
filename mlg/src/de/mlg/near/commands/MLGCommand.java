package de.mlg.near.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mlg.near.main.Main;
import de.mlg.near.mlg.MLG;
import de.mlg.near.utils.Erroru;
import de.mlg.near.utils.GeneralUtils;

public class MLGCommand implements CommandExecutor {
    MLG mlg;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            mlg = new MLG();
            mlg.setPlayer(p);
            mlg.setItem(Material.WATER);
            Main.runningMLGs.put(p, mlg);


            if(!argumentsAreValid(args)) {
                Erroru.printInvalidArgsError(p, "/mlg");
                return true;
            }

            if(args.length == 0) {
                mlg.setItem(Material.WATER_BUCKET);
                if(!mlg.isRunning()) {
                    mlg.handleMLG();
                }
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    HelpCommand.printHelp(p);
                    return false;
                }

                mlg.setItem(GeneralUtils.getMaterialFromString(args[0]));
                if(!mlg.isRunning()) {
                    mlg.handleMLG();
                }
            }
        }
        return false;
    }

    private boolean argumentsAreValid(String[] args) {
        if(args.length == 0) {
            return true;
        } else if(GeneralUtils.containsCaseInsensitive(args[0], mlg.allowedMLGTypes)) {
            return true;
        } else if(GeneralUtils.containsCaseInsensitive(args[0], new String[]{"help"})) {
            return true;
        }
        return false;
    }


}
