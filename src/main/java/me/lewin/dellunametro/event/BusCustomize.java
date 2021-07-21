package me.lewin.dellunametro.event;

import me.lewin.dellunametro.file.BusFile;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class BusCustomize {
    public static void setName(Integer id, String name){
        NPC npc = CitizensAPI.getNPCRegistry().getById(id);
        npc.setName(name);
    }
    public static void setSkin(Integer id, String name){
        NPC npc = CitizensAPI.getNPCRegistry().getById(id);
        npc.addTrait(SkinTrait.class);
        npc.getTraitNullable(SkinTrait.class).setSkinName(name);
    }
    public static void setIcon(String npcName, ItemStack icon){
        FileConfiguration config = BusFile.getBusConfig(npcName);
        config.set("icon", icon.getType().toString());
        BusFile.saveDataFile(config, BusFile.getBusFile(npcName));
    }
}
