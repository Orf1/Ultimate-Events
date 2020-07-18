package dev.orf1.plugins.ultimateevents;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class UltimateEventsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("ultimate-events.admin")){

            } else {
                player.sendMessage("a");
            }
        }else {
            CommandSender player = sender;
        }
        return false;
    }
}
