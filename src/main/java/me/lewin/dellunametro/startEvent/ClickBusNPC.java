package me.lewin.dellunametro.startEvent;

import me.lewin.dellunametro.event.BusCustomize;
import me.lewin.dellunametro.event.TeleportEvent;
import me.lewin.dellunametro.file.BusFile;
import me.lewin.dellunametro.gui.BusManagementGUI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class ClickBusNPC implements Listener {
    @EventHandler
    private void onInteractNPCEvent (NPCRightClickEvent event){
        if ((BusFile.getBusFile(event.getNPC().getName())).canRead()){
            Player player = event.getClicker();
            FileConfiguration busConfig = BusFile.getBusConfig(event.getNPC().getName());
            if (player.isSneaking()){
                if (busConfig.getString("uuid").equals(player.getUniqueId().toString())){
                    ItemStack item = player.getItemInHand();
                    switch (item.getType()){
                        case WRITTEN_BOOK:
                            if (item.getItemMeta().hasCustomModelData()){
                                if (item.getItemMeta().getCustomModelData() == 1){
                                    player.closeInventory();
                                    BookMeta itemMeta = (BookMeta) item.getItemMeta();
                                    String name = itemMeta.getTitle();
                                    if (BusFile.getBusFile(name).canRead()) {
                                        player.sendMessage("이미 존재하는 이름입니다.");
                                        return;
                                    }
                                    Integer npcID = busConfig.getInt("npcID");
                                    BusCustomize.setName(npcID, event.getNPC().getName(), name);
                                    item.setAmount(item.getAmount() - 1);
                                    player.sendMessage("변경되었습니다.");
                                    return;
                                }
                                else if (item.getItemMeta().getCustomModelData() == 2){
                                    Integer npcID = busConfig.getInt("npcID");
                                    BookMeta itemMeta = (BookMeta) item.getItemMeta();
                                    String name = itemMeta.getTitle();
                                    BusCustomize.setSkin(npcID, name);
                                    item.setAmount(item.getAmount() - 1);
                                    player.sendMessage("변경되었습니다.");
                                    return;
                                }
                            }
                    }
                    player.openInventory(new BusManagementGUI(player, event.getNPC().getName()).getInventory());
                    return;
                }
            }
            TeleportEvent.teleportToMetro(busConfig.getString("metro"), player);
        }
    }
}

