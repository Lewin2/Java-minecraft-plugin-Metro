package me.lewin.dellunametro.event;

import me.lewin.dellunametro.file.MetroFile;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.LookClose;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MetroNPC {
    public static void createNPC(String name, Player player){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, name);

        FileConfiguration config = MetroFile.getMetroConfig(name);
        config.set("npcID", npc.getId());
        config.set("npc", "set");
        MetroFile.saveDataFile(config, MetroFile.getMetroFile(name));

        npc.addTrait(LookClose.class);
        npc.getTraitNullable(LookClose.class).lookClose(true);

        npc.addTrait(SkinTrait.class);
        npc.getTraitNullable(SkinTrait.class).setShouldUpdateSkins(false);
        npc.getTraitNullable(SkinTrait.class).setSkinName("Lewin22");

        npc.spawn(player.getLocation());
    }

    public static void removeNPC(String name){
        FileConfiguration config = MetroFile.getMetroConfig(name);
        if (config.getString("npc") == "null") return;
        NPC npc = CitizensAPI.getNPCRegistry().getById(config.getInt("npcID"));
        npc.destroy();
        config.set("npcID", 0);
        config.set("npc", "null");
        MetroFile.saveDataFile(config, MetroFile.getMetroFile(name));
    }
}
