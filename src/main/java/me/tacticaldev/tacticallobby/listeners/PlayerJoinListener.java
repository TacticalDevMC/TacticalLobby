package me.tacticaldev.tacticallobby.listeners;

import me.tacticaldev.tacticallobby.api.managers.ConfigManager;
import me.tacticaldev.tacticallobby.api.utils.Icons;
import me.tacticaldev.tacticallobby.api.utils.NMSUtilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // actionbar
        String actionBarText = ConfigManager.getStringFromConfig("Join.ActionbarMessage");
        actionBarText.replace("%arrow%", Icons.ARROW)
                .replace("%arrow_bold%", Icons.ARROW_BOLD)
                .replace("%heart%", Icons.HEART)
                .replace("%coins%", Icons.COINS)
                .replace("%cross%", Icons.CROSS)
                .replace("ùcheckmark%", Icons.CHECKMARK)
                .replace("%germany%", Icons.GERMANY)
                .replace("%diamond%", Icons.DIAMOND)
                .replace("%triangle%", Icons.TRIANGLE)
                .replace("%square%", Icons.SQUARE);
        NMSUtilities.sendActionBar(player, actionBarText);

        // title
        String title = ConfigManager.getStringFromConfig("Join.Title.text"), subTitle = ConfigManager.getStringFromConfig("Join.Title.subTitle");
        int fadeIn = ConfigManager.getIntegerFromConfig("Join.Title.fadeOut"), stay = ConfigManager.getIntegerFromConfig("Join.Title.stay"), fadeout = ConfigManager.getIntegerFromConfig("Join.Title.fadeOut");

        NMSUtilities.sendTitle(player, title, subTitle, fadeIn, stay, fadeout);
    }
}
