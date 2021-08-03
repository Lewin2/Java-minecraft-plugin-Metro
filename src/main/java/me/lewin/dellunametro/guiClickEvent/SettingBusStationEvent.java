package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.BusStationNPC;
import me.lewin.dellunametro.event.SetBus;
import me.lewin.dellunametro.event.TeleportEvent;
import me.lewin.dellunametro.gui.BusStationGUI;
import me.lewin.dellunametro.gui.SettingBusGUI;
import me.lewin.dellunametro.gui.SettingBusStationGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingBusStationEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§9")) {
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;

            if (event.getCurrentItem().getItemMeta().hasCustomModelData()) {
                if (event.getCurrentItem().getItemMeta().getCustomModelData() == 1){
                    switch ((event.getCurrentItem()).getType()){
                        case ARROW:
                            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("다음 페이지") ){
                                String currentstr = event.getClickedInventory().getItem(49).getItemMeta().getLore().get(1).substring(0, event.getClickedInventory().getItem(49).getItemMeta().getLore().get(1).length()-4);
                                int current = Integer.parseInt(currentstr);
                                player.openInventory(new SettingBusStationGUI(player, event.getClickedInventory().getItem(49).getItemMeta().getDisplayName()).getInventory(current + 1));
                            }
                            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("이전 페이지")){
                                String currentstr = event.getClickedInventory().getItem(49).getItemMeta().getLore().get(1).substring(0, event.getClickedInventory().getItem(49).getItemMeta().getLore().get(1).length()-4);
                                int current = Integer.parseInt(currentstr);
                                player.openInventory(new SettingBusStationGUI(player, event.getClickedInventory().getItem(49).getItemMeta().getDisplayName()).getInventory(current - 1));
                            }
                    }
                    return;
                }
            }

            switch (event.getClick()){
                case LEFT:
                    TeleportEvent.teleportToBus(event.getCurrentItem().getItemMeta().getDisplayName(), player);
                    break;
                case SHIFT_LEFT:
                    SetBus.removeBus(event.getCurrentItem().getItemMeta().getDisplayName(), player);
                    String currentstr = event.getClickedInventory().getItem(49).getItemMeta().getLore().get(1).substring(0, event.getClickedInventory().getItem(49).getItemMeta().getLore().get(1).length()-4);
                    int current = Integer.parseInt(currentstr);
                    player.openInventory(new SettingBusStationGUI(player, event.getClickedInventory().getItem(49).getItemMeta().getDisplayName()).getInventory(current));
                    break;
            }

        }
    }
}
