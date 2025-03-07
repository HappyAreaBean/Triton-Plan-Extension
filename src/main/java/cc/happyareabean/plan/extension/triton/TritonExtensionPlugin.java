package cc.happyareabean.plan.extension.triton;

import com.djrapitops.plan.capability.CapabilityService;
import com.djrapitops.plan.extension.Caller;
import com.djrapitops.plan.extension.DataExtension;
import com.djrapitops.plan.extension.ExtensionService;

import java.util.Optional;

public interface TritonExtensionPlugin {

    /**
     * Initializes the Triton Plan Extension.
     */
    default void init() {
        logger("Initializing Triton Plan Extension");

        try {
            DataExtension extension = new TritonExtension();
            Optional<Caller> caller = ExtensionService.getInstance().register(extension);

            if (caller.isPresent() && isListenerAvailable()) {
                registerListener(caller.get());
                logger("Registered Triton Extension Listener");
            }

            CapabilityService.getInstance().registerEnableListener(
                    isPlanEnabled -> {
                        if (isPlanEnabled) init();
                    }
            );

            logger("Registered Triton Extension");
        } catch (Exception e) {
            logger("Error initializing Triton Plan Extension", e);
        }
    }

    /**
     * Checks if the listener for the Triton extension is available.
     *
     * @return true if the listener is available, false otherwise
     */
    default boolean isListenerAvailable() {
        return true;
    }

    /**
     * Registers a listener with the caller.
     *
     * @param caller the caller to register the listener with
     */
    default void registerListener(Caller caller) {

    }

    /**
     * Logs a message using the logger.
     *
     * @param message the message to log
     */
    void logger(String message);

    /**
     * Logs a message and an exception using the logger.
     *
     * @param message the message to log
     * @param throwable      the exception to log
     */
    void logger(String message, Throwable throwable);
}
