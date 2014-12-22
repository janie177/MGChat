package com.minegusta.mgchat.tags;

import com.demigodsrpg.chitchat.tag.PlayerTag;
import com.minegusta.mgraces.util.RaceManager;
import org.bukkit.entity.Player;

public class RaceTag extends PlayerTag {

    @Override
    public String getName() {
        return "race";
    }

    @Override
    public String getFor(Player player) {
        return RaceManager.getRace(player);
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
