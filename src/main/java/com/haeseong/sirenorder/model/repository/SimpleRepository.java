package com.haeseong.sirenorder.model.repository;

import com.haeseong.sirenorder.model.Entity;

import java.util.Collection;
import java.util.Optional;

public interface SimpleRepository<T extends Entity<K>, K> {

    Optional<T> findById(K id);

    Collection<T> findAll();

    T save(T data);
}
