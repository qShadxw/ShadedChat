package uk.co.tmdavies.shadedchat.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import uk.co.tmdavies.shadedchat.managers.ConfigManager;
import uk.co.tmdavies.shadedchat.managers.PlayerManager;
import uk.co.tmdavies.shadedchat.utils.ShadowUtils;

public class PlayerListener implements Listener {

    @EventHandler
    public void onChatASync(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        String chat = PlaceholderAPI.setPlaceholders(player, PlayerManager.getPlayerFormat(player)).replace("%message%", message);

        event.setFormat(ShadowUtils.Colour(chat));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String message = ConfigManager.getConfigurationFile("config").getString("Format.Join");
        message = PlaceholderAPI.setPlaceholders(player, message);

        event.setJoinMessage(ShadowUtils.Colour(message));
        PlayerManager.addPlayerFormat(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String message = ConfigManager.getConfigurationFile("config").getString("Format.Quit");
        message = PlaceholderAPI.setPlaceholders(player, message);

        event.setQuitMessage(ShadowUtils.Colour(message));
        PlayerManager.removePlayerFormat(player);
    }

}
