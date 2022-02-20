package de.kqray.economykqray.events;

import de.kqray.economykqray.util.ConfigHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws IOException {
        ConfigHandler c = new ConfigHandler();
        Player p = event.getPlayer();
        if (c.getString(p.getUniqueId().toString()+"."+"Money") == null){
            c.setInt(p.getUniqueId().toString()+"."+p.getName()+"."+"Money", 0);

            c.save();
        }
    }
}