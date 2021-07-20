package me.lewin.dellunametro.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MetroMenuGUI {
    Player player;

    public MetroMenuGUI(Player player) {
        this.player = player;
    }

    public Inventory getInventory(){
        Inventory inv = Bukkit.getServer().createInventory(null, 9, "§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§4");

        inv.setItem(1, center());
        inv.setItem(4, line1());
        inv.setItem(5, line2());
        inv.setItem(6, line3());
        inv.setItem(7, line4());

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, iconnull());
        }

        return inv;
    }

    private ItemStack center(){
        return IconDefaultGUI.iconDefault(Material.DIAMOND_BLOCK, "중앙역");
    }

    private ItemStack line1(){
        return IconDefaultGUI.iconDefault(Material.RED_WOOL, "1호선");
    }

    private ItemStack line2(){
        return IconDefaultGUI.iconDefault(Material.BLUE_WOOL, "2호선");
    }

    private ItemStack line3(){
        return IconDefaultGUI.iconDefault(Material.LIME_WOOL, "3호선");
    }

    private ItemStack line4(){
        return IconDefaultGUI.iconDefault(Material.YELLOW_WOOL, "4호선");
    }

    private ItemStack iconnull(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }

}
