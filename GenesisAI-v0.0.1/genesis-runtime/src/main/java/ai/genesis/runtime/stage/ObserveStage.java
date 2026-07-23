package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class ObserveStage implements CognitiveStage {
    @Override
    public String name() {
        return "ObserveStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        var observation = context.input();
        context.put("observation", observation);
        context.workingMemory().put("latestObservation", observation);
    }
}