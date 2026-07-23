package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class PersistStage implements CognitiveStage {
    @Override
    public String name() {
        return "PersistStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        context.put("finalOutput", "Processed: " + context.input());
    }
}
