package com.minegusta.mgchat.tags;


import com.demigodsrpg.chitchat.tag.PlayerTag;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.entity.Player;

public class FactionTag implements PlayerTag {
    @Override
    public String getName() {
        return "faction";
    }

    @Override
    public String getFor(Player player) {
        MPlayer uplayer = MPlayer.get(player);
        Faction faction = uplayer.getFaction();
        String factionName = faction.getName();
        if(factionName.contains("Wilderness")) factionName = "";
        else factionName = "[" + factionName + "]";
        return factionName;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
