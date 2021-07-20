package me.lewin.dellunametro;

import me.lewin.dellunametro.gui.BusCreateGUI;
import me.lewin.dellunametro.gui.MetroMenuGUI;
import me.lewin.dellunametro.gui.SettingMenuGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String args[]){
        if (args.length == 0) return true;
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (player.isOp()) {
            if (args.length != 1) return true;
            switch (args[0]){
                case "setting":
                case "s":
                    player.openInventory(new SettingMenuGUI(player).getInventory());
                    return true;
                case "open":
                case "o":
                    player.openInventory(new MetroMenuGUI(player).getInventory());
                    return true;
                case "create":
                case "c":
                    player.openInventory(new BusCreateGUI(player).getInventory());
                    return true;
            }
        }
        player.sendMessage("잘못된 사용입니다.");
        return true;
    }
}
