package ai.genesis.runtime;

import ai.genesis.api.runtime.BrainRuntime;
import ai.genesis.api.runtime.RuntimeState;

public class DefaultBrainRuntime implements BrainRuntime {
    private RuntimeState state = RuntimeState.CREATED;

    @Override
    public void initialize() {
        if (state != RuntimeState.CREATED && state != RuntimeState.STOPPED) {
            return;
        }
        state = RuntimeState.INITIALIZED;
    }

    @Override
    public String think(String input) {
        if (state == RuntimeState.CREATED) {
            initialize();
        }
        if (state == RuntimeState.STOPPED) {
            throw new IllegalStateException("Brain runtime is stopped.");
        }

        state = RuntimeState.RUNNING;
        try {
            return "Processed: " + input;
        } finally {
            state = RuntimeState.INITIALIZED;
        }
    }

    @Override
    public void shutdown() {
        state = RuntimeState.STOPPED;
    }

    @Override
    public RuntimeState state() {
        return state;
    }
}
