package org.gks.lld.cache.cache.storage;

import org.gks.lld.cache.cache.exceptions.NotFoundException;
import org.gks.lld.cache.cache.exceptions.StorageFullException;

public interface Storage<K, V> {

    public void add(K key, V value) throws StorageFullException;
    public V get(K key) throws NotFoundException;
    public void remove(K key) throws NotFoundException;
}
