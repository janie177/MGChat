package com.minegusta.mgchat.tags;

import com.demigodsrpg.chitchat.tag.DefaultPlayerTag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public enum RaceTag {

    DWARF(ChatColor.DARK_GRAY + "[Dwarf]", 3),
    ELF(ChatColor.DARK_GREEN + "[Elf]", 3),
    HUMAN(ChatColor.YELLOW + "[Human]", 3),
    DEMON(ChatColor.RED + "[Demon]", 3),
    ENDERBORN(ChatColor.DARK_PURPLE + "[Enderborn]", 3);


    private DefaultPlayerTag tag;

    private RaceTag(String text, int priority)
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
