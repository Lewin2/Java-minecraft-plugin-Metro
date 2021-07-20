package me.lewin.dellunametro.event;

import me.lewin.dellunametro.file.MetroFile;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.LookClose;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BusStationNPC {
    public static void createNPC(String name, Player player){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, name);

        FileConfiguration config = MetroFile.getMetroConfig(name.substring(0, name.length()-6));
        config.set("busnpcID", npc.getId());
        config.set("busnpc", "set");
        MetroFile.saveDataFile(config, MetroFile.getMetroFile(name.substring(0, name.length()-6)));

        npc.addTrait(LookClose.class);
        npc.getTraitNullable(LookClose.class).lookClose(true);

        npc.addTrait(SkinTrait.class);
        npc.getTraitNullable(SkinTrait.class).setShouldUpdateSkins(false);
        npc.getTraitNullable(SkinTrait.class).setSkinName("Bo_ox");

        npc.spawn(player.getLocation());
    }

    public static void removeNPC(String name){
        FileConfiguration config = MetroFile.getMetroConfig(name.substring(0, name.length()-6));
        NPC npc = CitizensAPI.getNPCRegistry().getById(config.getInt("busnpcID"));
        config.set("busnpc", "null");
        config.set("busnpcID", 0);
        MetroFile.saveDataFile(config, MetroFile.getMetroFile(name.substring(0, name.length()-6)));
        npc.destroy();
    }
}
