package uk.co.tmdavies.shadedchat.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.HashMap;

public class PlayerManager {

    private static final HashMap<Player, String> playerFormatCache = new HashMap<>();

    public static String getChatFormat(Player player) {
        for (PermissionAttachmentInfo permission : player.getEffectivePermissions()) {
            String perm = permission.getPermission();
            if (perm.contains("shadedchat.format.")) {
                return perm;
            }
        }
        return null;
    }

    public static void addPlayerFormat(Player player) {
        if (playerFormatCache.containsKey(player)) {
            return;
        }

        String formatPerm = getChatFormat(player);
        String format;

        if (formatPerm != null) {
            String perm = formatPerm.replace("shadedchat.format.", "");
            format = ConfigManager.getConfigurationFile("config").getString("Format.Chat." + perm);
            format = format == null ? ConfigManager.getConfigurationFile("config").getString("Format.Chat.Default") : format;
        } else {
            format = ConfigManager.getConfigurationFile("config").getString("Format.Chat.Default");
        }

        playerFormatCache.put(player, format);
    }

    public static void removePlayerFormat(Player player) {
        if (!playerFormatCache.containsKey(player)) {
            return;
        }

        playerFormatCache.remove(player);
    }

    public static void reloadPlayerFormats() {
        playerFormatCache.clear();

        for (Player player : Bukkit.getOnlinePlayers()) {
            addPlayerFormat(player);
        }
    }

    public static String getPlayerFormat(Player player) {
        return playerFormatCache.get(player);
    }

}
