package me.lewin.dellunametro.gui;

import me.lewin.dellunametro.file.MetroFile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SettingBusGUI {
    Player player;

    public SettingBusGUI(Player player) {
        this.player = player;
    }

    public Inventory getInventory(){
        Inventory inv = Bukkit.getServer().createInventory(null, 54, "§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§3");

        inv.setItem(19, sub("장미역"));
        inv.setItem(28, sub("동백역"));
        inv.setItem(21, sub("수국역"));
        inv.setItem(30, sub("물망초역"));
        inv.setItem(23, sub("국화역"));
        inv.setItem(32, sub("진달래역"));
        inv.setItem(25, sub("개나리역"));
        inv.setItem(34, sub("해바라기역"));

        inv.setItem(53, back());

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, iconnull());
        }
        return inv;
    }

    private ItemStack sub(String name){
        FileConfiguration config = MetroFile.getMetroConfig(name);

        List<String> lore = new ArrayList<>();

        lore.add("§7 좌클릭: 관리창 열기");
        lore.add("§7 쉬프트+좌클릭: npc 생성");
        lore.add("§7 쉬프트+우클릭: npc 삭제");
        lore.add("§7 -------------------");
        lore.add("§7 NPC: " + config.get("busnpc"));

        switch (name){
            case "장미역":
                return IconDefaultGUI.iconDefault(Material.RED_WOOL, "§a장미역", lore);
            case "동백역":
                return IconDefaultGUI.iconDefault(Material.RED_WOOL, "§a동백역", lore);
            case "수국역":
                return IconDefaultGUI.iconDefault(Material.BLUE_WOOL, "§a수국역", lore);
            case "물망초역":
                return IconDefaultGUI.iconDefault(Material.BLUE_WOOL, "§a물망초역", lore);
            case "국화역":
                return IconDefaultGUI.iconDefault(Material.LIME_WOOL, "§a국화역", lore);
            case "진달래역":
                return IconDefaultGUI.iconDefault(Material.LIME_WOOL, "§a진달래역", lore);
            case "개나리역":
                return IconDefaultGUI.iconDefault(Material.YELLOW_WOOL, "§a개나리역", lore);
            case "해바라기역":
                return IconDefaultGUI.iconDefault(Material.YELLOW_WOOL, "§a해바라기역", lore);
        }
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }
    private ItemStack iconnull(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }
    private ItemStack back(){
        return IconDefaultGUI.iconDefault(Material.BARRIER, "§a뒤로가기");
    }
}
