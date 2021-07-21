package me.lewin.dellunametro.startEvent;

import me.lewin.dellunametro.file.BusFile;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class BusCustomizeClick implements Listener {
    @EventHandler
    private void onInteractNPCEvent (NPCRightClickEvent event){
        if ((BusFile.getBusFile(event.getNPC().getName())).canRead()){
            Player player = event.getClicker();

            FileConfiguration busConfig = BusFile.getBusConfig(event.getNPC().getName());
            Integer npcID = busConfig.getInt("npcID");

            ItemStack item = player.getItemInHand();
            switch (item.getType()){
                case WRITTEN_BOOK:


            }
        }
    }
}
