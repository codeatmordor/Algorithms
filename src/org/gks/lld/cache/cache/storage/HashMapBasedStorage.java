package org.gks.lld.cache.cache.storage;

import org.gks.lld.cache.cache.exceptions.NotFoundException;
import org.gks.lld.cache.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
    Map<Key, Value> mp = new HashMap<>();

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        mp.put(key, value);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        return mp.get(key);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        mp.remove(key);
    }
}
