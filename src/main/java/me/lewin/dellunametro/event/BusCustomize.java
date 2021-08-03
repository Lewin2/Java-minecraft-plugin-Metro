package me.lewin.dellunametro.event;

import me.lewin.dellunametro.file.BusFile;
import me.lewin.dellunametro.file.MetroFile;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class BusCustomize {
    public static void setName(Integer id,String npcName, String name){
        FileConfiguration busConfig = BusFile.getBusConfig(npcName);
        busConfig.set("name", name);
        BusFile.getBusFile(npcName).delete();
        BusFile.saveDataFile(busConfig, BusFile.getBusFile(name));

        FileConfiguration metroConfig = MetroFile.getMetroConfig(busConfig.getString("metro"));
        List<String> list = metroConfig.getStringList("list");
        Integer index = list.indexOf(npcName);
        list.set(index, name);
        metroConfig.set("list", list);
        MetroFile.saveDataFile(metroConfig, MetroFile.getMetroFile(busConfig.getString("metro")));

        NPC npc = CitizensAPI.getNPCRegistry().getById(id);
        npc.setName(name);

        return;
    }
    public static void setSkin(Integer id, String name){
        NPC npc = CitizensAPI.getNPCRegistry().getById(id);
        npc.removeTrait(SkinTrait.class);
        npc.addTrait(SkinTrait.class);
        npc.getTraitNullable(SkinTrait.class).setShouldUpdateSkins(false);
        npc.getTraitNullable(SkinTrait.class).setSkinName(name);
    }
    public static void setIcon(String npcName, String icon){
        FileConfiguration config = BusFile.getBusConfig(npcName);
        config.set("icon", icon);
        BusFile.saveDataFile(config, BusFile.getBusFile(npcName));
    }
}
