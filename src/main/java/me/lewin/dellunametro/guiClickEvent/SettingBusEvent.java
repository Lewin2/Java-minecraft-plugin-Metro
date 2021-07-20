package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.BusStationNPC;
import me.lewin.dellunametro.gui.SettingBusGUI;
import me.lewin.dellunametro.gui.SettingMenuGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingBusEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§3")) {
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;
            switch ((event.getCurrentItem()).getType()) {
                case BARRIER:
                    player.openInventory(new SettingMenuGUI(player).getInventory());
                    break;
                case COPPER_BLOCK:
                    break;
                case RED_WOOL:
                case BLUE_WOOL:
                case LIME_WOOL:
                case YELLOW_WOOL:
                    switch (event.getClick()){
                        case LEFT:
                            break;
                        case SHIFT_LEFT:
                            BusStationNPC.createNPC(nameset(event.getSlot()), player);
                            player.openInventory(new SettingBusGUI(player).getInventory());
                            break;
                        case SHIFT_RIGHT:
                            BusStationNPC.removeNPC(nameset(event.getSlot()));
                            player.openInventory(new SettingBusGUI(player).getInventory());
                    }

            }
        }
    }

    private String nameset(Integer num){
        String name;
        switch (num){
            case 19:
                name = "장미역 버스정류장";
                break;
            case 28:
                name = "동백역 버스정류장";
                break;
            case 21:
                name = "수국역 버스정류장";
                break;
            case 30:
                name = "물망초역 버스정류장";
                break;
            case 23:
                name = "국화역 버스정류장";
                break;
            case 32:
                name = "진달래역 버스정류장";
                break;
            case 25:
                name = "개나리역 버스정류장";
                break;
            case 34:
                name = "해바라기역 버스정류장";
                break;
            default:
                name = "null";
                break;
        }
        return name;
    }
}

