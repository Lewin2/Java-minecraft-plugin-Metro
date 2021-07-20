package me.lewin.dellunametro.startEvent;

import me.lewin.dellunametro.file.MetroFile;
import me.lewin.dellunametro.gui.MetroMenuGUI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClickMetroNPC implements Listener {
    @EventHandler
    private void onInteractNPCEvent(NPCRightClickEvent event){
        Player player = event.getClicker();

        if ((MetroFile.getMetroFile(event.getNPC().getName())).canRead()){
            player.openInventory(new MetroMenuGUI(player).getInventory());
        }
    }
}
