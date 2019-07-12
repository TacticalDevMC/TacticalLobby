package me.tacticaldev.tacticallobby;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class TacticalLobby extends JavaPlugin {

    @Getter
    private static TacticalLobby instance;
    private static ConsoleCommandSender console = Bukkit.getConsoleSender();

    List<String> authors = this.getDescription().getAuthors();
    String version = this.getDescription().getVersion();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        console.sendMessage("[TacticalLobby] Plugin staat aan! Author(s): " + authors + " V: " + version);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;

        console.sendMessage("[TacticalLobby] Plugin staat uit! Author(s): " + authors + " V: " + version);
    }
}
