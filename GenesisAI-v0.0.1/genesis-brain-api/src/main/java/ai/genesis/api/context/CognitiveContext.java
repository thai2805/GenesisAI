package ai.genesis.api.context;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class CognitiveContext {
    private final String id;
    private final String input;
    private final WorkingMemory workingMemory;
    private final Map<String, Object> attributes = new LinkedHashMap<>();

    public CognitiveContext(String input) {
        this.id = UUID.randomUUID().toString();
        this.input = Objects.requireNonNull(input, "input must not be null");
        this.workingMemory = new WorkingMemory();
    }

    public String id() {
        return id;
    }

    public String input() {
        return input;
    }

    public WorkingMemory workingMemory() {
        return workingMemory;
    }

    public void put(String key, Object value) {
        attributes.put(Objects.requireNonNull(key, "key must not be null"), value);
    }

    public Object get(String key) {
        return attributes.get(key);
    }

    public <T> T get(String key, Class<T> type) {
        Object value = attributes.get(key);
        if (value == null) {
            return null;
        }
        return type.cast(value);
    }

    public Map<String, Object> attributes() {
        return Map.copyOf(attributes);
    }
}