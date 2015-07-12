package com.minegusta.mgchat.listener;

import com.demigodsrpg.chitchat.Chitchat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class WastelandListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        Player s = e.getPlayer();
        String message = e.getMessage();
        
        if(message.startsWith("/"))return;
        
        e.setCancelled(true);
        Bukkit.getOnlinePlayers().stream().filter(p -> p.getLocation().distance(e.getPlayer().getLocation()) < 900).forEach(p -> p.sendMessage(Chitchat.getChatFormat().getFormattedMessage(s, message)));
    }
}
