package me.lewin.dellunametro.event;

import me.lewin.dellunametro.file.BusFile;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.LookClose;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BusNPC {
    public static void createNPC(String name, Player player){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, name);

        FileConfiguration config = BusFile.getBusConfig(name);
        config.set("npcID", npc.getId());
        BusFile.saveDataFile(config, BusFile.getBusFile(name));

        npc.addTrait(LookClose.class);
        npc.getTraitNullable(LookClose.class).lookClose(true);

        npc.addTrait(SkinTrait.class);
        npc.getTraitNullable(SkinTrait.class).setShouldUpdateSkins(false);
        npc.getTraitNullable(SkinTrait.class).setSkinName(player.getName());

        npc.spawn(player.getLocation());
    }

    public static void removeNPC(String name){
        FileConfiguration config = BusFile.getBusConfig(name);
        NPC npc = CitizensAPI.getNPCRegistry().getById(config.getInt("npcID"));
        npc.destroy();
    }
}
