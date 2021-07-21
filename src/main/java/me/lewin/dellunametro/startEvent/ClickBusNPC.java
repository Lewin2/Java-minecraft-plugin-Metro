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
        if ((BusFile.getBusFile(event.getNPC().getName())).canRead()){
            Player player = event.getClicker();
            FileConfiguration busConfig = BusFile.getBusConfig(event.getNPC().getName());
            if (player.isSneaking()){
                if (busConfig.getString("uuid").equals(player.getUniqueId().toString())){
                    player.openInventory(new BusManagementGUI(player, event.getNPC().getName()).getInventory());
                    return;
                }
            }
            TeleportEvent.teleportToMetro(busConfig.getString("metro"), player);
        }
    }
}

