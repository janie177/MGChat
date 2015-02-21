package com.minegusta.mgchat.listener;


import com.massivecraft.factions.Factions;
import com.massivecraft.factions.Rel;
import com.massivecraft.factions.cmd.arg.ARFaction;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class FactionChatListener implements Listener
{
    @EventHandler(priority = EventPriority.LOWEST)
    public void onEvent(AsyncPlayerChatEvent e)
    {
        String message = e.getMessage();
        if(!message.startsWith("!"))
        {
            return;
        }

        e.getRecipients().clear();

        Player p = e.getPlayer();
        MPlayer uplayer = MPlayer.get(p);
        Faction faction = uplayer.getFaction();
        String factionName = faction.getName();
        if(factionName.contains("Wilderness")) return;

        if(message.startsWith("!!"))
        {
            String send = ChatColor.DARK_PURPLE + "[AC] " + ChatColor.LIGHT_PURPLE + message.substring(2, message.length() - 1);
            for(String s : faction.getRelationWishes().keySet())
            {
                if(faction.getRelationWish(faction = ARFaction.get().read("s").getResult()) == Rel.ALLY)
                {
                    Faction ally = ARFaction.get().read(s).getResult();
                    for(Player allyPlayer : ally.getOnlinePlayers())
                    {
                        allyPlayer.sendMessage(send);
                    }
                }
            }
        }
        else
        {
            String send = ChatColor.GREEN + "[FC] " + ChatColor.DARK_GREEN + message.substring(1, message.length() - 1);
            for(Player player : faction.getOnlinePlayers())
            {
                player.sendMessage(send);
            }
        }
    }
}
