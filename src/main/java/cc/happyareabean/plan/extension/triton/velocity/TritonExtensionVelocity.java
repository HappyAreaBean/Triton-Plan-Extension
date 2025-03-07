package cc.happyareabean.plan.extension.triton.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import cc.happyareabean.plan.extension.triton.TritonExtensionPlugin;
import org.slf4j.Logger;

public class TritonExtensionVelocity implements TritonExtensionPlugin {

    @Inject
    private final Logger logger;

    @Inject
    public TritonExtensionVelocity(Logger logger) {
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialize(ProxyInitializeEvent event) {
        init();
    }

    @Override
    public boolean isListenerAvailable() {
        return false;
    }

    @Override
    public void logger(String message) {
        logger.info(message);
    }

    @Override
    public void logger(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
