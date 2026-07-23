package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class RepresentStage implements CognitiveStage {
    @Override
    public String name() {
        return "RepresentStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        context.put("representation", "REPRESENTED: " + context.get("observation"));
    }
}
