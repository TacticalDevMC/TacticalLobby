//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package me.tacticaldev.tacticallobby.api.utils;

import me.tacticaldev.tacticallobby.api.managers.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {
    private static String prefix = FileManager.get("config.yml").getString("prefix");


    public static String color(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static void sendMessageFromConfig(Player player, String path) {
        String message = FileManager.get("messages.yml").getString(path);
        player.sendMessage(color(message.replace("%prefix%", getPrefix())));
    }

    public static String getFromConfig(String path) {
        return FileManager.get("config.yml").getString(path);
    }

    public static String replacePathFromConfig(String path, String replace, String replaceWith) {
        return color(FileManager.get("messages.yml").getString(path).replace(replace, replaceWith)).replace("%prefix%", getPrefix());
    }

    public static String getPrefix() {
        return prefix;
    }
}
