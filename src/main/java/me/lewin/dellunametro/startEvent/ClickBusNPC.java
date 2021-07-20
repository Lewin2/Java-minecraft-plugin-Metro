package me.lewin.dellunametro.startEvent;

import me.lewin.dellunametro.event.TeleportEvent;
import me.lewin.dellunametro.file.BusFile;
import me.lewin.dellunametro.gui.BusManagementGUI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClickBusNPC implements Listener {
    @EventHandler
    private void onInteractNPCEvent (NPCRightClickEvent event){
        Player player = event.getClicker();
        if ((BusFile.getBusFile(event.getNPC().getName())).canRead()){
            if (player.isSneaking()){
                FileConfiguration busConfig = BusFile.getBusConfig(event.getNPC().getName());

                if (busConfig.getString("uuid").equals(player.getUniqueId().toString())){
                    player.openInventory(new BusManagementGUI(player, event.getNPC().getName()).getInventory());
                    return;
                }
            }
            FileConfiguration busConfig = BusFile.getBusConfig(event.getNPC().getName());
            TeleportEvent.teleportToMetro(busConfig.getString("metro"), player);
        }
    }
}

