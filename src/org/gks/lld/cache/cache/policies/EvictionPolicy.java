package org.gks.lld.cache.cache.policies;

public interface EvictionPolicy<K> {

    public K evictKey();
    public void keyAccessed(K key);
}
