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

public class SettingMetroGUI {
    Player player;

    public SettingMetroGUI(Player player) {
        this.player = player;
    }

    public Inventory getInventory(){
        Inventory inv = Bukkit.getServer().createInventory(null, 54, "§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§1");

        inv.setItem(4, train());

        inv.setItem(13, cent("중앙역"));

        inv.setItem(19, glass("1호선"));
        inv.setItem(21, glass("2호선"));
        inv.setItem(23, glass("3호선"));
        inv.setItem(25, glass("4호선"));

        inv.setItem(28, sub("장미역", 1, 1));
        inv.setItem(37, sub("동백역", 1, 2));

        inv.setItem(30, sub("수국역", 2, 1));
        inv.setItem(39, sub("물망초역", 2, 2));

        inv.setItem(32, sub("국화역", 3, 1));
        inv.setItem(41, sub("진달래역", 3, 2));

        inv.setItem(34, sub("개나리역", 4, 1));
        inv.setItem(43, sub("해바라기역", 4, 2));

        inv.setItem(53, back());

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, iconnull());
        }

        return inv;
    }

    private ItemStack cent(String name){
        if (!(MetroFile.getMetroFile(name).canRead())) {
            List<String> lore = new ArrayList<>();
            lore.add("§7 클릭 시 기차역 좌표가 설정됩니다");
            return IconDefaultGUI.iconDefault(Material.COAL_BLOCK, "§a중앙 기차역", lore);
        }
        FileConfiguration config = MetroFile.getMetroConfig(name);
        List<String> lore = new ArrayList<>();
        lore.add("§7 좌클릭: 좌표로 텔레포트");
        lore.add("§7 우클릭: 설정 삭제");
        lore.add("§7 쉬프트+좌클릭: npc 생성");
        lore.add("§7 쉬프트+우클릭: npc 삭제");
        lore.add("§7 -------------------");
        lore.add("§7 NPC: " + config.get("npc"));
        lore.add("§7 X: " + config.get("x"));
        lore.add("§7 Y: " + config.get("y"));
        lore.add("§7 Z: " + config.get("z"));
        return IconDefaultGUI.iconDefault(Material.DIAMOND_BLOCK, "§a중앙 기차역", lore);
    }

    private ItemStack glass(String name){
        if (name == "1호선")
            return IconDefaultGUI.iconDefault(Material.RED_STAINED_GLASS_PANE, "§a" + name);
        else if (name == "2호선")
            return IconDefaultGUI.iconDefault(Material.BLUE_STAINED_GLASS_PANE, "§a" + name);
        else if (name == "3호선")
            return IconDefaultGUI.iconDefault(Material.LIME_STAINED_GLASS_PANE , "§a" + name);
        else
            return IconDefaultGUI.iconDefault(Material.YELLOW_STAINED_GLASS_PANE, "§a" + name);
    }

    private ItemStack sub(String name, Integer line, Integer location){
        if (!(MetroFile.getMetroFile(name).canRead())) {
            List<String> lore = new ArrayList<>();
            lore.add("§7 클릭 시 기차역 좌표가 설정됩니다");
            return IconDefaultGUI.iconDefault(Material.COAL_BLOCK, "§a서브 기차역(" + line + "호선 " + location + "번)", lore);
        }
        FileConfiguration config = MetroFile.getMetroConfig(name);
        List<String> lore = new ArrayList<>();
        lore.add("§7 좌클릭: 좌표로 텔레포트");
        lore.add("§7 우클릭: 설정 삭제");
        lore.add("§7 쉬프트+좌클릭: npc 생성");
        lore.add("§7 쉬프트+우클릭: npc 삭제");
        lore.add("§7 -------------------");
        lore.add("§7 NPC: " + config.get("npc"));
        lore.add("§7 X: " + config.get("x"));
        lore.add("§7 Y: " + config.get("y"));
        lore.add("§7 Z: " + config.get("z"));
        return IconDefaultGUI.iconDefault(Material.GOLD_BLOCK, "§a서브 기차역(" + line + "호선 " + location + "번)", lore);
    }

    private ItemStack train(){
        if (!(MetroFile.getMetroFile("train").canRead())) {
            List<String> lore = new ArrayList<>();
            lore.add("§7 클릭 시 중앙 기차역 좌표가 설정됩니다");
            return IconDefaultGUI.iconDefault(Material.COAL_BLOCK, "§a기차", lore);
        }
        FileConfiguration config = MetroFile.getMetroConfig("train");
        List<String> lore = new ArrayList<>();
        lore.add("§7 좌클릭: 좌표로 텔레포트");
        lore.add("§7 우클릭: 설정 삭제");
        lore.add("§7 X: " + config.get("x"));
        lore.add("§7 Y: " + config.get("y"));
        lore.add("§7 Z: " + config.get("z"));
        return IconDefaultGUI.iconDefault(Material.COPPER_BLOCK, "§a기차", lore);
    }

    private ItemStack iconnull(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }

    private ItemStack back(){
        return IconDefaultGUI.iconDefault(Material.BARRIER, "§a뒤로가기");
    }
}
