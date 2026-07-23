package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class CriticStage implements CognitiveStage {
    @Override
    public String name() {
        return "CriticStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        context.put("critic", "APPROVED");
    }
}
