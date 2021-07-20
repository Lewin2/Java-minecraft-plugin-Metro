package me.lewin.dellunametro.file;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerFileSet implements Listener {
    @EventHandler
    private void onPlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if (!(PlayerFile.getPlayerFile(player.getUniqueId().toString()).canRead())){
            creatDataFile(player);
        }

        setReloadPlayerName(player, player.getUniqueId().toString());
    }

    private void setReloadPlayerName(Player player, String uuid)
    {
        FileConfiguration config = PlayerFile.getPlayerConfig(uuid);
        config.set("name", player.getName());
        PlayerFile.saveDataFile(config, PlayerFile.getPlayerFile(uuid));
    }

    private void creatDataFile(Player player){

        String uuid = player.getUniqueId().toString();
        FileConfiguration config = PlayerFile.getPlayerConfig(uuid);
        List<String> busname = new ArrayList<>();

        config.set("name", player.getName());
        config.set("uuid", player.getUniqueId().toString());
        config.set("buscount", 0);
        config.set("busname", busname);

        PlayerFile.saveDataFile(config, PlayerFile.getPlayerFile(uuid));
    }
}
