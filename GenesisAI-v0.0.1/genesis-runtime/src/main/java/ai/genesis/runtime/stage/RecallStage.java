package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class RecallStage implements CognitiveStage {
    @Override
    public String name() {
        return "RecallStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        context.put("recall", "RECALLED");
    }
}
