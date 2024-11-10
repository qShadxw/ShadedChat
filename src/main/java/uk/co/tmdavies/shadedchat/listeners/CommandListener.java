package uk.co.tmdavies.shadedchat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;
import uk.co.tmdavies.shadedchat.managers.PlayerManager;
import uk.co.tmdavies.shadedchat.managers.PluginManager;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage();

        if (!(command.contains("lp") || command.contains("luckperms"))) {
            return;
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                PlayerManager.reloadPlayerFormats();
            }
        }.runTaskLater(PluginManager.getPluginInstance(), 5);
    }
}
