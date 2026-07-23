package ai.genesis.api.event;

import java.time.Instant;
import java.util.Objects;

public record BrainEvent(
        String type,
        String contextId,
        String stageName,
        Instant timestamp,
        String message
) {
    public BrainEvent {
        Objects.requireNonNull(type, "type must not be null");
        Objects.requireNonNull(contextId, "contextId must not be null");
        timestamp = timestamp == null ? Instant.now() : timestamp;
    }
}
