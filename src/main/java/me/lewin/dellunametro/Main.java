package me.lewin.dellunametro;

import me.lewin.dellunametro.file.PlayerFileSet;
import me.lewin.dellunametro.guiClickEvent.*;
import me.lewin.dellunametro.startEvent.ClickBusCreate;
import me.lewin.dellunametro.startEvent.ClickBusNPC;
import me.lewin.dellunametro.startEvent.ClickBusStationNPC;
import me.lewin.dellunametro.startEvent.ClickMetroNPC;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Plugin plugin = JavaPlugin.getPlugin(Main.class);

        this.getCommand("metro").setExecutor(new Commands());
        Bukkit.getPluginManager().registerEvents(new GlobalEvent(), this);
        Bukkit.getPluginManager().registerEvents(new MetroMenuEvent(), this);
        Bukkit.getPluginManager().registerEvents(new MetroSubEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SettingMenuEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SettingMetroEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ClickMetroNPC(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFileSet(), this);
        Bukkit.getPluginManager().registerEvents(new ClickBusCreate(), this);
        Bukkit.getPluginManager().registerEvents(new BusCreateEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ClickBusNPC(), this);
        Bukkit.getPluginManager().registerEvents(new BusManagementEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SettingBusEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ClickBusStationNPC(), this);
        Bukkit.getPluginManager().registerEvents(new BusStationEvent(), this);

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
    }
}
