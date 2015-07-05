package com.minegusta.mgchat;

import com.demigodsrpg.chitchat.Chitchat;
import com.demigodsrpg.chitchat.format.ChatFormat;
import com.demigodsrpg.chitchat.tag.DefaultPlayerTag;
import com.demigodsrpg.chitchat.tag.PlayerTag;
import com.demigodsrpg.chitchat.tag.WorldPlayerTag;
import com.minegusta.mgchat.listener.FactionChatListener;
import com.minegusta.mgchat.listener.StaffChatListener;
import com.minegusta.mgchat.tags.FactionTag;
import com.minegusta.mgchat.tags.RaceTag;
import com.minegusta.mgchat.tags.RankTag;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static Plugin PLUGIN;

    @Override
    public void onEnable()
    {
        //Set plugin
        PLUGIN = this;

        //Adding tags (priority matters)
        ChatFormat format = Chitchat.getChatFormat();
        format.add(new WorldPlayerTag());

        //Only enable factions tags when factions is enabled.
        if(Bukkit.getPluginManager().isPluginEnabled("Factions"))
        {
            Bukkit.getPluginManager().registerEvents(new FactionChatListener(), this);
            format.add(new FactionTag());
        }
        
        Bukkit.getPluginManager().registerEvents(new StaffChatListener(), this);

        if(Bukkit.getPluginManager().isPluginEnabled("MGRacesRedone")) format.add(new RaceTag());

        for(RankTag tag : RankTag.values()) {

            format.add(tag.getTag());
        }
    }

    @Override
    public void onDisable()
    {

    }

}
