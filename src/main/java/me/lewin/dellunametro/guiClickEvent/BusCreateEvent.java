package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.SetBus;
import me.lewin.dellunametro.file.PlayerFile;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BusCreateEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§6")) {
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;
            switch ((event.getCurrentItem()).getType()) {
                case DIAMOND:
                    player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                    FileConfiguration config = PlayerFile.getPlayerConfig(player.getUniqueId().toString());
                    Integer num = config.getInt("buscount") + 1;
                    SetBus.createBus(player.getName() + "(" + num + ")", player);
                    player.closeInventory();

            }
        }
    }
}