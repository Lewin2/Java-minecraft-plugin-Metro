package me.lewin.dellunametro.guiClickEvent;

import me.lewin.dellunametro.event.TeleportEvent;
import me.lewin.dellunametro.gui.MetroMenuGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MetroSubEvent  implements Listener {
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6         ˚₊· Delluna Metro ˚₊·§5")) {
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getType() == Material.WHITE_STAINED_GLASS_PANE) return;
            String name = "";
            switch ((event.getCurrentItem()).getType()) {
                case BARRIER:
                    player.openInventory(new MetroMenuGUI(player).getInventory());
                    return;
                case RED_WOOL:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("장미역"))
                        name = "장미역";
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("동백역"))
                        name = "동백역";
                    break;
                case BLUE_WOOL:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("수국역"))
                        name = "수국역";
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("물망초역"))
                        name = "물망초역";
                    break;
                case LIME_WOOL:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("국화역"))
                        name = "국화역";
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("진달래역"))
                        name = "진달래역";
                    break;
                case YELLOW_WOOL:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("개나리역"))
                        name = "개나리역";
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("해바라기역"))
                        name = "해바라기역";
                    break;
            }
            if (hasTicket(player)) {
                TeleportEvent.teleportMetro(name, player);
                return;
            }
            player.sendMessage("기차표를 소지하고 있지 않습니다.");
            return;
        }
    }
    private boolean hasTicket (Player player){
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
}
