
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.linkedlist;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentLRUCache<K, V> {

    private ConcurrentLinkedQueue<K> q = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<K, V> mp = new ConcurrentHashMap<>();
    private int cacheSize = 0;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public ConcurrentLRUCache(int size) {
        cacheSize = size;
    }

    public V get(K key) {
        readLock.lock();
        try {
            V val = null;
            if (mp.containsKey(key)) {
                q.remove(key);
                val = mp.get(key);
                q.add(key);
            }
            return val;
        } finally {
            readLock.unlock();
        }
    }

    public void put(K key, V val) {
        writeLock.lock();
        try {
            if (mp.containsKey(key)) {
                q.remove(key);
            }

            if (q.size() == cacheSize) {
                K qkey = q.poll();
                mp.remove(qkey);
            }

            q.add(key);
            mp.put(key, val);

        } finally {
            writeLock.unlock();
        }
    }

    public V evict(K key) {
        writeLock.lock();
        try {
            V val = null;
            if (mp.contains(key)) {
                val = mp.remove(key);
                q.remove(key);
            }
            return val;
        } finally {
            writeLock.unlock();
        }
    }
}
