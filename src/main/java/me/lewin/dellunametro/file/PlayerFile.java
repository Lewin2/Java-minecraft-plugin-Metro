package me.lewin.dellunametro.file;

import me.lewin.dellunametro.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class PlayerFile {
    public static final Plugin PLUGIN = JavaPlugin.getPlugin(Main.class);
    public static File getPlayerFile(String uuid) {
        return new File(PLUGIN.getDataFolder() + "\\Player", uuid + ".dat");
    }

    public static FileConfiguration getPlayerConfig(String uuid) {
        return YamlConfiguration.loadConfiguration(getPlayerFile(uuid));
    }

    public static void saveDataFile(FileConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("§cFile I/O Error!!");
        }
    }
}
