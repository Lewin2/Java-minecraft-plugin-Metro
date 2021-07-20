package me.lewin.dellunametro.startEvent;

import me.lewin.dellunametro.gui.BusCreateGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ClickBusCreate implements Listener {
    @EventHandler
    private void onPlayerUse(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        if (item.getType() == Material.PAPER){
            if (item.getItemMeta().hasCustomModelData()){
                if (item.getItemMeta().getCustomModelData() == 1004){
                    player.openInventory(new BusCreateGUI(player).getInventory());
                }
            }
        }
        return;
    }
}
