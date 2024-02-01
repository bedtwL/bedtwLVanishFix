package me.bedtwl.bedtwlvanishfix;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Loading...");
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("bedtwL Vanish Fix Enabled!");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        if (event.getPlayer().hasPermission("cmi.seevanished")|event.getPlayer().hasPermission("essentials.vanish.see"))
        {
            return;
        }
        for (Player p:getServer().getOnlinePlayers())
        {
            if (p.hasPermission("cmi.command.vanish")|p.hasPermission("essentials.vanish"))
            {
                Boolean v= PlaceholderAPI.setPlaceholders(p,"%cmi_user_vanished_symbol%").equalsIgnoreCase("§8[§7H§8]§r")|PlaceholderAPI.setPlaceholders(p,"%essentials_vanished%").equalsIgnoreCase("yes");
                if (v)
                {
                    event.getPlayer().hidePlayer(p);
                }
            }
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("bedtwL Vanish Fix Disabled!");
    }
}
