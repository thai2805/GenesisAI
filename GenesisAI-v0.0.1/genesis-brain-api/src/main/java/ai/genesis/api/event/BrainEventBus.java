package ai.genesis.api.event;

import java.util.function.Consumer;

public interface BrainEventBus {
    void publish(BrainEvent event);

    void subscribe(Consumer<BrainEvent> listener);
}
