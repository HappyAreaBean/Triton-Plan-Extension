package cc.happyareabean.plan.extension.triton.bungee;

import com.djrapitops.plan.extension.Caller;
import com.rexcantor64.triton.api.events.PlayerChangeLanguageBungeeEvent;
import com.rexcantor64.triton.api.language.Language;
import com.rexcantor64.triton.api.players.LanguagePlayer;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import cc.happyareabean.plan.extension.triton.TritonExtensionListenerBase;

public class TritonExtensionBungeeListener extends TritonExtensionListenerBase implements Listener {

    public TritonExtensionBungeeListener(Caller caller) {
        super(caller);
    }

    @EventHandler
    public void onPlayerChangeLanguage(PlayerChangeLanguageBungeeEvent event) {
        LanguagePlayer languagePlayer = event.getLanguagePlayer();
        Language oldLanguage = event.getOldLanguage();
        Language newLanguage = event.getNewLanguage();
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(languagePlayer.getUUID());

        if (player == null) return;
        if (oldLanguage == newLanguage) return;
        
        getCaller().updatePlayerData(languagePlayer.getUUID(), player.getName());
    }

}
