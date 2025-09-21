package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * @author bingxin.chen
 * @date 2019/6/6 12:47
 */
public class LeetCode146 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int cacheSize;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.cacheSize = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > cacheSize;
        }
    }

}
