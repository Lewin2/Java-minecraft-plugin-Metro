package me.lewin.dellunametro.gui;

import me.lewin.dellunametro.file.BusFile;
import me.lewin.dellunametro.file.MetroFile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SettingBusStationGUI {
    Player player;
    String name;

    public SettingBusStationGUI(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public Inventory getInventory(Integer current){
        Inventory inv = Bukkit.getServer().createInventory(null, 54, "§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§9");

        FileConfiguration metroconfig = MetroFile.getMetroConfig(name);
        int count = metroconfig.getInt("count");
        List<String> list = metroconfig.getStringList("list");
        for (int i = 45 * (current - 1); i < 45 * current; i++){
            if (i >= count) break;
            FileConfiguration busconfig = BusFile.getBusConfig(list.get(i));
            inv.addItem(IconDefaultGUI.iconDefault(Material.getMaterial(busconfig.getString("icon")), list.get(i)));
        }

        inv.setItem(49, station(current));
        if (current != 1)
            inv.setItem(48, previous());
        if (metroconfig.getInt("count") > 45*current)
            inv.setItem(50, next());
        for (int i = 45; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, iconnull());
        }

        return inv;
    }

    private ItemStack station(Integer current){
        List<String> lore = new ArrayList<>();
        lore.add("§7 -------------------");
        lore.add(current + " 페이지");
        lore.add("§7 -------------------");

        switch (name){
            case "장미역":
                return IconDefaultGUI.iconDefault(Material.RED_WOOL, "장미역", lore,1);
            case "동백역":
                return IconDefaultGUI.iconDefault(Material.RED_WOOL, "동백역", lore, 1);
            case "수국역":
                return IconDefaultGUI.iconDefault(Material.BLUE_WOOL, "수국역", lore, 1);
            case "물망초역":
                return IconDefaultGUI.iconDefault(Material.BLUE_WOOL, "물망초역", lore, 1);
            case "국화역":
                return IconDefaultGUI.iconDefault(Material.LIME_WOOL, "국화역", lore, 1);
            case "진달래역":
                return IconDefaultGUI.iconDefault(Material.LIME_WOOL, "진달래역", lore, 1);
            case "개나리역":
                return IconDefaultGUI.iconDefault(Material.YELLOW_WOOL, "개나리역", lore, 1);
            case "해바라기역":
                return IconDefaultGUI.iconDefault(Material.YELLOW_WOOL, "해바라기역", lore, 1);
        }
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }

    private ItemStack next(){
        return IconDefaultGUI.iconDefault(Material.ARROW, "다음 페이지", 1);
    }
    private ItemStack previous(){
        return IconDefaultGUI.iconDefault(Material.ARROW, "이전 페이지", 1);
    }

    private ItemStack iconnull(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ", 1);
    }
}
