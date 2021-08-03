package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.SetBus;
import me.lewin.dellunametro.file.BusFile;
import me.lewin.dellunametro.gui.IconDefaultGUI;
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
                case BARRIER:
                    SetBus.removeBus(name, player);
                    player.closeInventory();
                    break;
                case RED_WOOL:
                    FileConfiguration config = BusFile.getBusConfig(name);
                    if (!(hasmoney(player))){
                        player.sendMessage("돈이 부족합니다.");
                        break;
                    }
                    config.set("paid", Boolean.valueOf(true));
                    BusFile.saveDataFile(config, BusFile.getBusFile(name));
                    event.getInventory().setItem(2, IconDefaultGUI.iconDefault(Material.LIME_WOOL, "버스 연장하기"));
                    player.sendMessage("연장되었습니다.");
                    break;
                case LIME_WOOL:
                    player.sendMessage("이미 연장하셨습니다.");
            }
        }
    }

    private boolean hasmoney (Player player){
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) {
                continue;
            }
            if (item.getType() == Material.BLUE_DYE) {
                if (item.getItemMeta().hasCustomModelData()) {
                    if (item.getItemMeta().getCustomModelData() == 1000) {
                        item.setAmount(item.getAmount() - 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}