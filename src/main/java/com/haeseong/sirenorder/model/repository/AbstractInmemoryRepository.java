package com.haeseong.sirenorder.model.repository;

import com.haeseong.sirenorder.model.Entity;

import java.util.*;

public abstract class AbstractInmemoryRepository<T extends Entity<K>, K> implements SimpleRepository<T, K> {
    protected Map<K, T> map = new HashMap<>();

    @Override
    public Optional<T> findById(final K id) {
        final T data = map.get(id);
        return Optional.ofNullable(data);
    }

    @Override
    public Collection<T> findAll() {
        return map.values();
    }

    @Override
    public T save(final T data) {
        Objects.requireNonNull(data, "'data' must not be null");
        final K key = data.getId();
        map.put(key, data);
        return data;
    }
}
