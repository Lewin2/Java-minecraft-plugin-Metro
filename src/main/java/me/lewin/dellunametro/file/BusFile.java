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

public class BusFile {
    public static final Plugin PLUGIN = JavaPlugin.getPlugin(Main.class);

    public static void creatDataFile(String name, Player player){

        FileConfiguration config = getBusConfig(name);
        Location location = player.getLocation();
        String metro = setCloseMetro(location);

        config.set("name", name);
        config.set("npcID", 0);
        config.set("uuid", player.getUniqueId().toString());
        config.set("icon", "STONE");
        config.set("paid", Boolean.valueOf(true));
        config.set("station", Boolean.valueOf(false));
        config.set("metro", metro);
        config.set("location", location);

        saveDataFile(config, BusFile.getBusFile(name));
    }

    public static String setCloseMetro(Location location){
        List<Integer> distancelist = new ArrayList<>();
        List<String> metrolist = new ArrayList<>();
        for (File metro : MetroFile.getMetroFiles()){
            if (metro.getName().contains("train.dat")) continue;
            if (metro.getName().contains("중앙역.dat")) continue;
            FileConfiguration config = YamlConfiguration.loadConfiguration(metro);
            Integer distance = (int) location.distance(config.getLocation("location"));
            distancelist.add(distance);
            metrolist.add(metro.getName());
        }
        int min = distancelist.stream().min(Integer::compareTo).orElse(-1);
        String name = metrolist.get(distancelist.indexOf(min));
        return name.substring(0,name.length() - 4);
    }

    public static File[] getBusFiles() {
        return new File(PLUGIN.getDataFolder() + "\\Bus").listFiles();
    }

    public static File getBusFile(String name) {
        return new File(PLUGIN.getDataFolder() + "\\Bus", name + ".dat");
    }

    public static FileConfiguration getBusConfig(String name) {
        return YamlConfiguration.loadConfiguration(getBusFile(name));
    }

    public static void saveDataFile(FileConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("§cFile I/O Error!!");
        }
    }

    public static void removeDataFile(String name){
        getBusFile(name).delete();
    }
}
