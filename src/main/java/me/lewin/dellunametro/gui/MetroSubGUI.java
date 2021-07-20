package me.lewin.dellunametro.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MetroSubGUI {
    Player player;

    public MetroSubGUI(Player player) {
        this.player = player;
    }

    public Inventory getInventory(Material material){
        Inventory inv = Bukkit.getServer().createInventory(null, 9, "§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§5");

        inv.setItem(2, num1(material));
        inv.setItem(6, num2(material));
        inv.setItem(8, back());

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, iconnull());
        }

        return inv;
    }

    private ItemStack num1(Material material){
        if (material == Material.RED_WOOL)
            return IconDefaultGUI.iconDefault(Material.RED_WOOL, "§a장미역");
        else if (material == Material.BLUE_WOOL)
            return IconDefaultGUI.iconDefault(Material.BLUE_WOOL, "§a수국역");
        else if (material == Material.LIME_WOOL)
            return IconDefaultGUI.iconDefault(Material.LIME_WOOL , "§a국화역");
        else
            return IconDefaultGUI.iconDefault(Material.YELLOW_WOOL, "§a개나리역");
    }

    private ItemStack num2(Material material){
        if (material == Material.RED_WOOL)
            return IconDefaultGUI.iconDefault(Material.RED_WOOL, "§a동백역");
        else if (material == Material.BLUE_WOOL)
            return IconDefaultGUI.iconDefault(Material.BLUE_WOOL, "§a물망초역");
        else if (material == Material.LIME_WOOL)
            return IconDefaultGUI.iconDefault(Material.LIME_WOOL , "§a진달래역");
        else
            return IconDefaultGUI.iconDefault(Material.YELLOW_WOOL, "§a해바라기역");
    }

    private ItemStack iconnull(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }
    private ItemStack back(){
        return IconDefaultGUI.iconDefault(Material.BARRIER, "§a뒤로가기");
    }
}
