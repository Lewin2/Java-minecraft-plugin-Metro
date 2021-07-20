package me.lewin.dellunametro.startEvent;

import me.lewin.dellunametro.gui.BusStationGUI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClickBusStationNPC implements Listener {
    @EventHandler
    private void onInteractNPCEvent (NPCRightClickEvent event) {
        Player player = event.getClicker();
        switch (event.getNPC().getName()){
            case "장미역 버스정류장":
            case "동백역 버스정류장":
            case "수국역 버스정류장":
            case "물망초역 버스정류장":
            case "국화역 버스정류장":
            case "개나리역 버스정류장":
            case "진달래역 버스정류장":
            case "해바라기역 버스정류장":
                player.openInventory(new BusStationGUI(player, event.getNPC().getName().substring(0, event.getNPC().getName().length()-6)).getInventory(1));
                break;
        }
    }
}
