package ai.genesis.runtime.scheduler;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.scheduler.BrainScheduler;
import ai.genesis.api.stage.CognitiveStage;

import java.util.List;
import java.util.Objects;

public class LinearCognitiveScheduler implements BrainScheduler {
    @Override
    public void schedule(CognitiveContext context, List<CognitiveStage> stages) {
        Objects.requireNonNull(context, "context must not be null");
        Objects.requireNonNull(stages, "stages must not be null");

        for (CognitiveStage stage : stages) {
            stage.execute(context);
        }
    }
}
