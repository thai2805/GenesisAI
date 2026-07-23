package ai.genesis.api.scheduler;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

import java.util.List;

public interface BrainScheduler {
    void schedule(CognitiveContext context, List<CognitiveStage> stages);
}
