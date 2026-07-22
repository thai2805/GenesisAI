package ai.genesis.api.runtime;

public interface BrainRuntime {
    void initialize();

    String think(String input);

    void shutdown();

    RuntimeState state();
}
