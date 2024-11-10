package uk.co.tmdavies.shadedchat.utils;

import org.bukkit.ChatColor;
import uk.co.tmdavies.shadedchat.managers.ConfigManager;

public class ShadowUtils {

    public static String Chat(String message, Object... args) {
        return ChatColor.translateAlternateColorCodes('&', String.format(ConfigManager.getColouredTextFromLang("Prefix") + message, args));
    }

    public static String Colour(String message, Object... args) {
        return ChatColor.translateAlternateColorCodes('&', String.format(message, args));
    }

    public static String ChatRaw(String message) {
        return ChatColor.translateAlternateColorCodes('&', ConfigManager.getColouredTextFromLang("Prefix") + message);
    }

    public static String colourRaw(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
