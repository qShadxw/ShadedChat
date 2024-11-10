package uk.co.tmdavies.shadedchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.tmdavies.shadedchat.managers.ConfigManager;
import uk.co.tmdavies.shadedchat.managers.PluginManager;
import uk.co.tmdavies.shadedchat.utils.ShadowLogger;

public final class ShadedChat extends JavaPlugin {

    public static ShadowLogger logger;

    @Override
    public void onLoad() {
        // Init Logger
        logger = new ShadowLogger();

        // Setting Instance
        PluginManager.setInstance(this);

        // Init Configs
        ConfigManager.initFiles();
    }

    @Override
    public void onEnable() {
        // Checking for PlaceholderAPI
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            logger.error(ShadowLogger.Reason.API, "PlaceholderAPI is not installed. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        // Registering Commands
        PluginManager.registerCommands();

        // Registering Listeners
        PluginManager.registerListeners();

        // Startup
        logger.startUp(getDescription().getVersion(), getDescription().getAuthors());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
