package ai.genesis.runtime;

import ai.genesis.api.Brain;
import ai.genesis.api.runtime.BrainRuntime;

public class DefaultBrain implements Brain {
    private final BrainRuntime runtime;

    public DefaultBrain(BrainRuntime runtime) {
        this.runtime = runtime;
    }

    @Override
    public String think(String input) {
        return runtime.think(input);
    }
}