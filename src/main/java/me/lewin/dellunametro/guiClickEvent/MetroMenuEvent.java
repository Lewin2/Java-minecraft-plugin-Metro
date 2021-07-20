package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.TeleportEvent;
import me.lewin.dellunametro.gui.MetroSubGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MetroMenuEvent implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§4")){
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;
            switch ((event.getCurrentItem()).getType()) {
                case DIAMOND_BLOCK:
                    if (hasTicket(player)) {
                        TeleportEvent.teleportMetro("중앙역", player);
                        break;
                    }
                    player.sendMessage("기차표를 소지하고 있지 않습니다.");
                    break;
                case RED_WOOL:
                case BLUE_WOOL:
                case LIME_WOOL:
                case YELLOW_WOOL:
                    player.openInventory(new MetroSubGUI(player).getInventory((event.getCurrentItem()).getType()));
                    break;
            }
        }
    }
    private boolean hasTicket(Player player){
        for (ItemStack item : player.getInventory().getContents()){
            if (item == null){continue;}
            if (item.getType() == Material.PAPER) {
                if (item.getItemMeta().hasCustomModelData()){
                    if (item.getItemMeta().getCustomModelData() == 1003) {
                        item.setAmount(item.getAmount() - 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
