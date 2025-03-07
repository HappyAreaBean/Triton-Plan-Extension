package cc.happyareabean.plan.extension.triton;

import com.djrapitops.plan.extension.CallEvents;
import com.djrapitops.plan.extension.DataExtension;
import com.djrapitops.plan.extension.annotation.PluginInfo;
import com.djrapitops.plan.extension.annotation.StringProvider;
import com.djrapitops.plan.extension.icon.Color;
import com.djrapitops.plan.extension.icon.Family;
import com.rexcantor64.triton.api.TritonAPI;
import com.rexcantor64.triton.api.players.LanguagePlayer;

import java.util.UUID;

/**
 * DataExtension for Triton
 *
 * @author HappyAreaBean
 */
@PluginInfo(name = "Triton", iconName = "language", iconFamily = Family.SOLID, color = Color.NONE)
public class TritonExtension implements DataExtension {

    @Override
    public CallEvents[] callExtensionMethodsOn() {
        return new CallEvents[]{CallEvents.PLAYER_JOIN, CallEvents.PLAYER_LEAVE,
                CallEvents.SERVER_EXTENSION_REGISTER, CallEvents.SERVER_PERIODICAL};
    }

    private LanguagePlayer getLanguagePlayer(UUID playerUUID) {
        return TritonAPI.getInstance().getPlayerManager().get(playerUUID);
    }

    @StringProvider(
            text = "Language",
            description = "The language code of the player currently selected language.",
            priority = 1000,
            iconName = "globe"
    )
    public String language(UUID playerUUID) {
        return getLanguagePlayer(playerUUID).getLang().getName();
    }

    @StringProvider(
            text = "Language Name",
            description = "The display name of the player currently selected language.",
            priority = 900,
            iconName = "globe"
    )
    public String languageDisplay(UUID playerUUID) {
        return getLanguagePlayer(playerUUID).getLang().getRawDisplayName();
    }

}