package ai.genesis.runtime.event;

import ai.genesis.api.event.BrainEvent;
import ai.genesis.api.event.BrainEventBus;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class DefaultBrainEventBus implements BrainEventBus {
    private final List<Consumer<BrainEvent>> listeners = new CopyOnWriteArrayList<>();

    @Override
    public void publish(BrainEvent event) {
        for (Consumer<BrainEvent> listener : listeners) {
            listener.accept(event);
        }
    }

    @Override
    public void subscribe(Consumer<BrainEvent> listener) {
        listeners.add(listener);
    }
}
