package me.lewin.dellunametro.event;

import me.lewin.dellunametro.file.BusFile;
import me.lewin.dellunametro.file.MetroFile;
import me.lewin.dellunametro.file.PlayerFile;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

public class SetBus {
    public static void createBus(String name, Player player){
        BusFile.creatDataFile(name, player);
        BusNPC.createNPC(name, player);

        FileConfiguration metroConfig = MetroFile.getMetroConfig(BusFile.setCloseMetro(player.getLocation()));
        List<String> metrolist = metroConfig.getStringList("list");
        metroConfig.set("count", metroConfig.getInt("count") + 1);
        metrolist.add(name);
        metroConfig.set("list", metrolist);
        MetroFile.saveDataFile(metroConfig, MetroFile.getMetroFile(BusFile.setCloseMetro(player.getLocation())));

        FileConfiguration playerConfig = PlayerFile.getPlayerConfig(player.getUniqueId().toString());
        List<String> playerlist = playerConfig.getStringList("busname");
        playerConfig.set("buscount", playerConfig.getInt("buscount") + 1);
        playerlist.add(name);
        playerConfig.set("busname", playerlist);
        PlayerFile.saveDataFile(playerConfig, PlayerFile.getPlayerFile(player.getUniqueId().toString()));

        player.sendMessage("버스 정류장이 설정되었습니다.");
    }

    public static void removeBus(String name, Player player){
        FileConfiguration busConfig = BusFile.getBusConfig(name);

        FileConfiguration metroConfig = MetroFile.getMetroConfig(busConfig.getString("metro"));
        List<String> metrolist = metroConfig.getStringList("list");
        metroConfig.set("count", metroConfig.getInt("count") - 1);
        metrolist.remove(name);
        metroConfig.set("list", metrolist);
        MetroFile.saveDataFile(metroConfig, MetroFile.getMetroFile(busConfig.getString("metro")));

        FileConfiguration playerConfig = PlayerFile.getPlayerConfig(player.getUniqueId().toString());
        List<String> playerlist = playerConfig.getStringList("busname");
        playerConfig.set("buscount", playerConfig.getInt("buscount") - 1);
        playerlist.remove(name);
        playerConfig.set("busname", playerlist);
        PlayerFile.saveDataFile(playerConfig, PlayerFile.getPlayerFile(player.getUniqueId().toString()));

        BusNPC.removeNPC(name);
        BusFile.removeDataFile(name);

        player.sendMessage("버스 정류장이 삭제되었습니다.");
    }


}
