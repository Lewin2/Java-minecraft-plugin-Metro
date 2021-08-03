package me.lewin.dellunametro.event;

import me.lewin.dellunametro.file.BusFile;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ResetPay {
    public static void reset(){
        for (File file : BusFile.getBusFiles()){
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("paid", Boolean.valueOf(false));
            BusFile.saveDataFile(config, file);
        }
    }
}
