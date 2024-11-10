package uk.co.tmdavies.shadedchat.managers;

import uk.co.tmdavies.shadedchat.utils.ShadowConfig;
import uk.co.tmdavies.shadedchat.utils.ShadowUtils;

import java.util.HashMap;

public class ConfigManager {

    private static HashMap<String, ShadowConfig> configurationFiles;

    public static void initFiles() {
        // Init HashMap
        configurationFiles = new HashMap<>();

        // Init Configs
        configurationFiles.put("lang", new ShadowConfig("sample_lang.yml", false, true, true, "lang.yml"));
        configurationFiles.put("config", new ShadowConfig("sample_config.yml", false, true, true, "config.yml"));
    }

    public static ShadowConfig getConfigurationFile(String configFile) {
        return configurationFiles.get(configFile);
    }

    public static String getColouredTextFromLang(String path) {
        ShadowConfig config = getConfigurationFile("lang");

        return ShadowUtils.colourRaw(config.getString(path)
                .replace("%prefix%", config.getString("Prefix")));
    }

    public static void reloadConfigs() {
        configurationFiles.values().forEach(ShadowConfig::load);
    }

}
