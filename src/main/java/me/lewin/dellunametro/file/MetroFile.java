package me.lewin.dellunametro.file;

import me.lewin.dellunametro.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetroFile {
    public static final Plugin PLUGIN = JavaPlugin.getPlugin(Main.class);

    public static void creatDataFile(String name, Player player){

        FileConfiguration config = getMetroConfig(name);
        Location location = player.getLocation();

        List<String> list = new ArrayList<>();

        config.set("name", name);
        config.set("location", location);
        config.set("npc", "null");
        config.set("npcID", 0);
        config.set("busnpc", "null");
        config.set("busnpcID", 0);
        config.set("x", (int) location.getX());
        config.set("y", (int) location.getY());
        config.set("z", (int) location.getZ());
        config.set("count", 0);
        config.set("list", list);

        saveDataFile(config, getMetroFile(name));
    }

    public static File getMetroFile(String name) {
        return new File(PLUGIN.getDataFolder() + "\\Metro", name + ".dat");
    }

    public static File[] getMetroFiles() {
        return new File(PLUGIN.getDataFolder() + "\\Metro").listFiles();
    }

    public static FileConfiguration getMetroConfig(String name) {
        return YamlConfiguration.loadConfiguration(getMetroFile(name));
    }

    public static void saveDataFile(FileConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("§cFile I/O Error!!");
        }
    }

    public static void removeDataFile(String name){
        getMetroFile(name).delete();
    }
}
