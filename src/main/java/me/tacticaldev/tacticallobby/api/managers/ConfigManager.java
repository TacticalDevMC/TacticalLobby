package me.tacticaldev.tacticallobby.api.managers;

public class ConfigManager {


    public static String getStringFromConfig(String configPath) {
        if (FileManager.get("config.yml").getString(configPath) != null) {
            return FileManager.get("config.yml").getString(configPath);
        }
        return null;
    }

    public static int getIntegerFromConfig(String configPath) {
        if (FileManager.get("config.yml").getString(configPath) != null) {
            return FileManager.get("config.yml").getInt(configPath);
        }
        return 0;
    }

    public static boolean getBooleanFromConfig(String configPath) {
        if (FileManager.get("config.yml").getString(configPath) != null) {
            return FileManager.get("config.yml").getBoolean(configPath);
        }
        return false;
    }
}
