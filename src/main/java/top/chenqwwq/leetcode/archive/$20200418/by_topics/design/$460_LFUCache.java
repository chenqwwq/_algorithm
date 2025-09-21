package top.chenqwwq.leetcode.archive.$20200418.by_topics.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 460. LFU缓存
 * <p>
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * <p>
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * <p>
 * 示例：
 * <p>
 * LFUCache cache = new LFUCache( 2 /* capacity (缓存容量)  );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回 1
 * cache.put(3,3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4,4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 *
 * @author chen
 * @date 2019/11/30 下午4:02
 */
public class $460_LFUCache {
    static class LFUCache {
        private Long time = 0l;
        /**
         * 映射,用于O(1)的复杂度取数
         */
        private Map<Integer, Pair> maps;
        /**
         * 优先级队列,用于将元素按照频率排序,淘汰直接从队头开始
         */
        private PriorityQueue<Pair> queue;
        /**
         * 容量
         */
        private int capacity;
        /**
         * 当前元素数量
         */
        private int size = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            maps = new HashMap<>();
            queue = new PriorityQueue<>((o1, o2) -> {
                if (o1.freq > o2.freq) {
                    return -1;
                }
                if (o1.freq < o2.freq) {
                    return 1;
                }

                return o2.getTime.compareTo(o1.getTime);
            });
        }

        private Pair newPair(Integer key, Integer value) {
            return new Pair(key, value, 1, time++);
        }

        public int get(int key) {
            if (maps.containsKey(key)) {
                final Pair pair = maps.get(key);
                queue.remove(pair);
                pair.freq++;
                pair.getTime = time++;
                maps.put(pair.key, pair);
                queue.offer(pair);
                return pair.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (maps.containsKey(key)) {
                final Pair pair = maps.get(key);
                queue.remove(pair);
                pair.freq++;
                pair.getTime = time++;
                pair.value = value;

                maps.put(key, pair);
                queue.offer(pair);

                // 替换不需要淘汰元素
            } else {
                // 满了之后淘汰旧值 System.nanoTime();

                while (size >= capacity) {
                    if (!queue.isEmpty()) {
                        final Pair poll = queue.poll();
                        maps.remove(poll.key);
                        size--;
                    } else {
                        return;
                    }
                }

                // 增加新值
                final Pair pair = newPair(key, value);
                maps.put(key, pair);
                queue.offer(pair);
                size++;
            }
        }

        /**
         * 本來想繼承HashMap實現一個类似于LinkedHashMap的东西
         * 但是几个钩子方法都是默认访问权限,包外无法访问
         */
        private class Pair {
            /**
             * key
             */
            private Integer key;

            /**
             * value
             */
            private Integer value;

            /**
             * 访问次数
             */
            private Integer freq;

            private Long getTime;

            Pair(Integer key, Integer value, Integer freq, Long getTime) {
                this.key = key;
                this.value = value;
                this.getTime = getTime;
                this.freq = freq;

            }
        }
    }
}
