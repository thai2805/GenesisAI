package ai.genesis.api.stage;

import ai.genesis.api.context.CognitiveContext;

public interface CognitiveStage {
    String name();

    void execute(CognitiveContext context);
}
