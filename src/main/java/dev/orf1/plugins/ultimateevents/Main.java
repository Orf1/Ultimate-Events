package dev.orf1.plugins.ultimateevents;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("events").setExecutor(new UltimateEventsCommand());
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(null);
        player.setGameMode(GameMode.ADVENTURE);
    }

    @EventHandler
    public void onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent e){
        Player player = e.getPlayer();
        if (!player.hasPermission("ultimateevents.bypass.gamemode")) {
            if (e.getNewGameMode() != GameMode.ADVENTURE) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e){
        Player player = e.getPlayer();
        if (!player.hasPermission("ultimateevents.bypass.build")){
            e.setCancelled(true);
        }
    }
}
