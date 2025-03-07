package cc.happyareabean.plan.extension.triton.spigot;

import com.djrapitops.plan.extension.Caller;
import cc.happyareabean.plan.extension.triton.TritonExtensionPlugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TritonExtensionSpigot extends JavaPlugin implements TritonExtensionPlugin {

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().isPluginEnabled("Plan"))
            init();
    }

    @Override
    public void registerListener(Caller caller) {
        getServer().getPluginManager().registerEvents(new TritonExtensionSpigotListener(caller), this);
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
