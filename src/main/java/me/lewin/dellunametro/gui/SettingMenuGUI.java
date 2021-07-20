package me.lewin.dellunametro.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SettingMenuGUI {
    Player player;

    public SettingMenuGUI(Player player) {
        this.player = player;
    }

    public Inventory getInventory(){
        Inventory inv = Bukkit.getServer().createInventory(null, 9, "§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§0");
        inv.setItem(2, metro());
        inv.setItem(6, bus());
        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, iconnull());
        }
        return inv;
    }

    private ItemStack metro(){
        return IconDefaultGUI.iconDefault(Material.DIAMOND, "§a기차역 관리");
    }

    private ItemStack bus(){
        return IconDefaultGUI.iconDefault(Material.EMERALD, "§a버스정류장 관리");
    }

    private ItemStack iconnull(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }

}
