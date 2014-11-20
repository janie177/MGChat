package com.minegusta.mgchat.tags;

import com.demigodsrpg.chitchat.tag.DefaultPlayerTag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public enum RankTag
{
    ADMIN(ChatColor.DARK_RED + "[A]", 4),
    MODERATOR(ChatColor.DARK_AQUA + "[M]", 4),
    MODPLUS(ChatColor.DARK_AQUA + "[M" + ChatColor.GOLD + "+" + ChatColor.DARK_AQUA + "]", 4),
    TRUSTED(ChatColor.BLUE + "[T]", 4),
    OWNER(ChatColor.YELLOW + "[O]", 4),
    OVERSEER(ChatColor.GRAY + "«" + ChatColor.GOLD + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + ChatColor.GRAY + "»", 4),
    BUILDERPLUS(ChatColor.DARK_GREEN + "[B+]", 3),
    BUILDER(ChatColor.GREEN + "[B]", 3),
    DONOR10(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "10" + ChatColor.GOLD + "]", 3),
    DONOR20(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "20" + ChatColor.GOLD + "]", 3),
    DONOR30(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "30" + ChatColor.GOLD + "]", 3),
    DONOR40(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "40" + ChatColor.GOLD + "]", 3),
    DONOR50(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "50" + ChatColor.GOLD + "]", 3),
    DONOR60(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "60" + ChatColor.GOLD + "]", 3),
    DONOR70(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "70" + ChatColor.GOLD + "]", 3),
    DONOR80(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "80" + ChatColor.GOLD + "]", 3),
    DONOR90(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "90" + ChatColor.GOLD + "]", 3),
    DONOR100(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "100" + ChatColor.GOLD + "]", 3),
    DONOR150(ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "150" + ChatColor.GOLD + "]", 3);

    
    private DefaultPlayerTag tag;
    
    private RankTag(String text, int priority)
    {
        tag = new DefaultPlayerTag(name(), "minegusta.rank." + name().toLowerCase(), text, priority);
        try 
        {
            Bukkit.getPluginManager().addPermission(new Permission("minegusta.rank." + name().toLowerCase(), PermissionDefault.FALSE));
        } 
        catch (Exception ignored){}
    }
    
    public DefaultPlayerTag getTag()
    {
        return tag;
    }
}
