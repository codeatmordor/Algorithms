package org.gks.lld.cache.cache;

import org.gks.lld.cache.cache.policies.EvictionPolicy;
import org.gks.lld.cache.cache.storage.Storage;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key,Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key,Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){

    }


}
