package me.lewin.dellunametro.event;

import me.lewin.dellunametro.Main;
import me.lewin.dellunametro.file.BusFile;
import me.lewin.dellunametro.file.MetroFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TeleportEvent{
    public static void teleportMetro(String name, Player player){
        Plugin plugin = JavaPlugin.getPlugin(Main.class);
        teleportToMetro("train", player);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.sendMessage("arriving at 10..");
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                player.sendMessage("arriving at 5..");
                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    player.sendMessage("arriving at 4..");
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        player.sendMessage("arriving at 3..");
                        Bukkit.getScheduler().runTaskLater(plugin, () -> {
                            player.sendMessage("arriving at 2..");
                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                player.sendMessage("arriving at 1..");
                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                    teleportToMetro(name, player);
                                }, 20L);
                            }, 20L);
                        }, 20L);
                    }, 20L);
                }, 20L);
            }, 100L);
        }, 20L);
    }

    public static void teleportToMetro(String name, Player player) {
        FileConfiguration config = MetroFile.getMetroConfig(name);
        Location location = config.getLocation("location");
        player.teleport(location);
        player.sendMessage("샤랄라 뿅!");
    }

    public static void teleportToBus(String name, Player player) {
        FileConfiguration config = BusFile.getBusConfig(name);
        Location location = config.getLocation("location");
        player.teleport(location);
        player.sendMessage("샤랄라 뿅!");
    }
}
