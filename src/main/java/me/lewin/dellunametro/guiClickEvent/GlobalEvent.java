package me.lewin.dellunametro.guiClickEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GlobalEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event){
        if (isMetroInventory(event)){
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void onFakeItemCancel(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();

        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·"))
            player.getInventory().setContents(player.getInventory().getContents());
    }

    private boolean isMetroInventory(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return false;
        if (event.getCurrentItem() == null) return false;

        return event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·");
    }
}
