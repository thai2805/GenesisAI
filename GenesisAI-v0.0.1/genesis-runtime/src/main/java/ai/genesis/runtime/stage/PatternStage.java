package ai.genesis.runtime.stage;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.stage.CognitiveStage;

public class PatternStage implements CognitiveStage {
    @Override
    public String name() {
        return "PatternStage";
    }

    @Override
    public void execute(CognitiveContext context) {
        context.put("pattern", "PATTERN_FOUND");
    }
}
