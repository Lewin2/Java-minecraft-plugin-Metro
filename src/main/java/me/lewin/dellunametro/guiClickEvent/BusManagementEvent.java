package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.SetBus;
import me.lewin.dellunametro.file.BusFile;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BusManagementEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§7")) {
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;
            String name = event.getClickedInventory().getItem(0).getItemMeta().getDisplayName();
            switch ((event.getCurrentItem()).getType()) {
                case RED_WOOL:
                    SetBus.removeBus(name, player);
                    player.closeInventory();
                    break;
                case EMERALD:
                    FileConfiguration config = BusFile.getBusConfig(name);
                    config.set("paid", Boolean.valueOf(true));
                    BusFile.saveDataFile(config, BusFile.getBusFile(name));
                    break;

            }
        }
    }

    private boolean hasmoney (Player player){
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) {
                continue;
            }
            if (item.getType() == Material.PAPER) {
                if (item.getItemMeta().hasCustomModelData()) {
                    if (item.getItemMeta().getCustomModelData() == 1003) {
                        item.setAmount(item.getAmount() - 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasbusstation (String name){
        FileConfiguration config = BusFile.getBusConfig(name);
        return config.getBoolean("station");
    }
}