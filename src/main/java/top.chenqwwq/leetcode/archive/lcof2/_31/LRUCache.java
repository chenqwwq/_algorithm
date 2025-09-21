package top.chenqwwq.leetcode.archive.lcof2._31;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2021/12/22
 **/
public class LRUCache {

    LinkedHashMap<Integer, Integer> CACHE;

    public LRUCache(int capacity) {
        CACHE = new LinkedHashMap<Integer, Integer>(capacity + 1, 1, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return CACHE.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        CACHE.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
