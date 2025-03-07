package cc.happyareabean.plan.extension.triton.spigot;

import com.djrapitops.plan.extension.Caller;
import com.rexcantor64.triton.api.events.PlayerChangeLanguageSpigotEvent;
import com.rexcantor64.triton.api.language.Language;
import com.rexcantor64.triton.api.players.LanguagePlayer;
import cc.happyareabean.plan.extension.triton.TritonExtensionListenerBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TritonExtensionSpigotListener extends TritonExtensionListenerBase implements Listener {

    public TritonExtensionSpigotListener(Caller caller) {
        super(caller);
    }

    @EventHandler
    public void onPlayerChangeLanguage(PlayerChangeLanguageSpigotEvent event) {
        LanguagePlayer languagePlayer = event.getLanguagePlayer();
        Language oldLanguage = event.getOldLanguage();
        Language newLanguage = event.getNewLanguage();
        Player player = Bukkit.getPlayer(languagePlayer.getUUID());

        if (player == null) return;
        if (oldLanguage == newLanguage) return;

        getCaller().updatePlayerData(languagePlayer.getUUID(), player.getName());
    }

}
