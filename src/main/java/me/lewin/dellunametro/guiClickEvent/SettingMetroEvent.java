package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.MetroNPC;
import me.lewin.dellunametro.event.TeleportEvent;
import me.lewin.dellunametro.file.MetroFile;
import me.lewin.dellunametro.gui.SettingMenuGUI;
import me.lewin.dellunametro.gui.SettingMetroGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingMetroEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§1")){
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;
            switch ((event.getCurrentItem()).getType()) {
                case BARRIER:
                    player.openInventory(new SettingMenuGUI(player).getInventory());
                    break;
                case COAL_BLOCK:
                    MetroFile.creatDataFile(nameset(event.getSlot()), player);
                    player.openInventory(new SettingMetroGUI(player).getInventory());
                    break;
                case DIAMOND_BLOCK:
                case GOLD_BLOCK:
                    switch (event.getClick()){
                        case LEFT:
                            TeleportEvent.teleportToMetro(nameset(event.getSlot()), player);
                            break;
                        case RIGHT:
                            MetroFile.removeDataFile(nameset(event.getSlot()));
                            break;
                        case SHIFT_LEFT:
                            MetroNPC.createNPC(nameset(event.getSlot()), player);
                            break;
                        case SHIFT_RIGHT:
                            MetroNPC.removeNPC(nameset(event.getSlot()));
                    }
                    player.openInventory(new SettingMetroGUI(player).getInventory());
                    break;
                case COPPER_BLOCK:
                    switch (event.getClick()){
                        case LEFT:
                            TeleportEvent.teleportToMetro(nameset(event.getSlot()), player);
                            break;
                        case RIGHT:
                            MetroFile.removeDataFile(nameset(event.getSlot()));
                            break;
                    }
                    player.openInventory(new SettingMetroGUI(player).getInventory());
            }
        }
    }

    private String nameset(Integer num){
        String name;
        switch (num){
            case 4:
                name = "train";
                break;
            case 13:
                name = "중앙역";
                break;
            case 28:
                name = "장미역";
                break;
            case 37:
                name = "동백역";
                break;
            case 30:
                name = "수국역";
                break;
            case 39:
                name = "물망초역";
                break;
            case 32:
                name = "국화역";
                break;
            case 41:
                name = "진달래역";
                break;
            case 34:
                name = "개나리역";
                break;
            default:
                name = "해바라기역";
                break;
        }
        return name;
    }
}
