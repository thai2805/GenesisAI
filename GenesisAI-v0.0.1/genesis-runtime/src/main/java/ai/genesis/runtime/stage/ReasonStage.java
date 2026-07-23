package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class ReasonStage implements CognitiveStage {
    @Override
    public String name() {
        return "ReasonStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        context.put("reasoning", "REASONED");
    }
}
