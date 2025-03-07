package cc.happyareabean.plan.extension.triton;

import com.djrapitops.plan.extension.Caller;

public class TritonExtensionListenerBase {

    private final Caller caller;

    public TritonExtensionListenerBase(Caller caller) {
        this.caller = caller;
    }

    public Caller getCaller() {
        return caller;
    }

}
