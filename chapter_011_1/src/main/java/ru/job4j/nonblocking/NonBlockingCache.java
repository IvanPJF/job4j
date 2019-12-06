package ru.job4j.nonblocking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingCache {

    private final Map<Integer, Base> cache = new ConcurrentHashMap<>();

    public void update(Base model) throws OptimisticException {
        int versionBefore = model.getVersion();
        this.cache.computeIfPresent(model.getId(), (key, value) -> {
            if (value.getVersion() != versionBefore) {
                throw new OptimisticException("The model version has been changed in another thread.");
            }
            value = model;
            value.upVersion();
            return value;
        });
    }

    public void add(Base model) {
        this.cache.putIfAbsent(model.getId(), model);
    }

    public void delete(Base model) {
        this.cache.remove(model.getId());
    }

    public Base getById(int id) {
        return this.cache.get(id);
    }
}
