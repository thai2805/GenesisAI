package ai.genesis.api.context;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class WorkingMemory {
    private final Map<String, Object> memory = new LinkedHashMap<>();

    public void put(String key, Object value) {
        memory.put(Objects.requireNonNull(key, "key must not be null"), value);
    }

    public Object get(String key) {
        return memory.get(key);
    }

    public <T> T get(String key, Class<T> type) {
        Object value = memory.get(key);
        if (value == null) {
            return null;
        }
        return type.cast(value);
    }

    public boolean contains(String key) {
        return memory.containsKey(key);
    }

    public void remove(String key) {
        memory.remove(key);
    }

    public void clear() {
        memory.clear();
    }

    public Map<String, Object> snapshot() {
        return Map.copyOf(memory);
    }
}
