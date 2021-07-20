package me.lewin.dellunametro.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BusManagementGUI {
    Player player;
    String name;

    public BusManagementGUI(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public Inventory getInventory(){
        Inventory inv = Bukkit.getServer().createInventory(null, 9, "§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§7");

        inv.setItem(0, npcName());
        inv.setItem(2, pay());
        inv.setItem(6, remove());

        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, iconnull());
        }

        return inv;
    }
    private ItemStack npcName(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, name);
    }

    private ItemStack pay(){
        return IconDefaultGUI.iconDefault(Material.EMERALD, "버스 연장하기");
    }

    private ItemStack remove(){
        return IconDefaultGUI.iconDefault(Material.RED_WOOL, "버스 정류장 삭제");
    }

    private ItemStack iconnull(){
        return IconDefaultGUI.iconDefault(Material.WHITE_STAINED_GLASS_PANE, " ");
    }

}
