package me.tacticaldev.tacticallobby;

import lombok.Getter;
import me.tacticaldev.tacticallobby.api.command.base.CommandBase;
import me.tacticaldev.tacticallobby.api.managers.FileManager;
import me.tacticaldev.tacticallobby.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
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

        // registers
        registerFile("config.yml");

        regvisterListeners(
                new PlayerJoinListener()
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;

        console.sendMessage("[TacticalLobby] Plugin staat uit! Author(s): " + authors + " V: " + version);
    }

    private void registerFile(String fileName) {
        FileManager.load(this, fileName);
    }

    private void regvisterListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach((listener -> {
            getInstance().getServer().getPluginManager().registerEvents(listener, this);
        }));
    }

    private void registerCommands(CommandBase... commands) {
        Arrays.stream(commands).forEach((command -> {
            getInstance().getCommand(command.getCommand()).setExecutor(command);
            getInstance().getCommand(command.getCommand()).setTabCompleter(command);
        }));
    }
}
