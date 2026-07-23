package ai.genesis.runtime;

import ai.genesis.api.context.CognitiveContext;
import ai.genesis.api.event.BrainEvent;
import ai.genesis.api.event.BrainEventBus;
import ai.genesis.api.runtime.BrainRuntime;
import ai.genesis.api.runtime.RuntimeState;
import ai.genesis.api.scheduler.BrainScheduler;
import ai.genesis.api.stage.CognitiveStage;
import ai.genesis.runtime.event.DefaultBrainEventBus;
import ai.genesis.runtime.scheduler.LinearCognitiveScheduler;
import ai.genesis.runtime.stage.*;

import java.time.Instant;
import java.util.List;

public class DefaultBrainRuntime implements BrainRuntime {
    private final BrainScheduler scheduler;
    private final BrainEventBus eventBus;
    private RuntimeState state = RuntimeState.CREATED;

    public DefaultBrainRuntime() {
        this.scheduler = new LinearCognitiveScheduler();
        this.eventBus = new DefaultBrainEventBus();
    }

    @Override
    public void initialize() {
        if (state != RuntimeState.CREATED && state != RuntimeState.STOPPED) {
            return;
        }
        state = RuntimeState.INITIALIZED;
    }

    @Override
    public String think(String input) {
        if (state == RuntimeState.CREATED) {
            initialize();
        }
        if (state == RuntimeState.STOPPED) {
            throw new IllegalStateException("Brain runtime is stopped.");
        }

        state = RuntimeState.RUNNING;
        try {
            var context = new CognitiveContext(input);
            eventBus.publish(new BrainEvent("CONTEXT_CREATED", context.id(), null, Instant.now(), "Context created"));

            scheduler.schedule(context, defaultStages());

            return context.get("finalOutput", String.class) != null
                    ? context.get("finalOutput", String.class)
                    : "Processed: " + input;
        } finally {
            state = RuntimeState.INITIALIZED;
        }
    }

    @Override
    public void shutdown() {
        state = RuntimeState.STOPPED;
    }

    @Override
    public RuntimeState state() {
        return state;
    }

    private List<CognitiveStage> defaultStages() {
        return List.of(
                new ObserveStage(),
                new RepresentStage(),
                new RecallStage(),
                new ReasonStage(),
                new PatternStage(),
                new CriticStage(),
                new LearnStage(),
                new PersistStage()
        );
    }
}