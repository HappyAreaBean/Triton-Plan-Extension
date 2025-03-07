package cc.happyareabean.plan.extension.triton.bungee;

import com.djrapitops.plan.extension.Caller;
import net.md_5.bungee.api.plugin.Plugin;
import cc.happyareabean.plan.extension.triton.TritonExtensionPlugin;

import java.util.logging.Level;

public class TritonExtensionBungee extends Plugin implements TritonExtensionPlugin {

    @Override
    public void onEnable() {
        if (getProxy().getPluginManager().getPlugin("Plan") != null)
            init();
    }

    @Override
    public void registerListener(Caller caller) {
        getProxy().getPluginManager().registerListener(this, new TritonExtensionBungeeListener(caller));
    }

    @Override
    public void logger(String message) {
        getLogger().info(message);
    }

    @Override
    public void logger(String message, Throwable throwable) {
        getLogger().log(Level.WARNING, message, throwable);
    }
}
