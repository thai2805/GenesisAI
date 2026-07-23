package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class LearnStage implements CognitiveStage {
    @Override
    public String name() {
        return "LearnStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        context.put("learning", "LEARNED");
    }
}
