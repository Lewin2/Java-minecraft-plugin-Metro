package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.gui.SettingBusGUI;
import me.lewin.dellunametro.gui.SettingMetroGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingMenuEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§0")){
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;
            switch ((event.getCurrentItem()).getType()) {
                case DIAMOND:
                    player.openInventory(new SettingMetroGUI(player).getInventory());
                    return;
                case EMERALD:
                    player.openInventory(new SettingBusGUI(player).getInventory());
                    return;
            }
        }
    }
}
