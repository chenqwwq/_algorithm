package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 *
 * @author chen
 * @date 19-6-16
 */
public class LeetCode1046 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1046().new Solution().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            // 好像在周赛里面做过,大顶堆解决

            // 1. 初始化与一个大顶堆
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            // 2. 导入全部数据
            for (int i : stones) {
                priorityQueue.add(i);
            }
            // 3. 取出堆顶的两个数组对撞
            while (priorityQueue.size() > 1) {
                final int abs = Math.abs(priorityQueue.poll() - priorityQueue.poll());
                if (abs > 0) {
                    priorityQueue.offer(abs);
                }
            }

            return priorityQueue.size() > 0 ? priorityQueue.poll() : 0;
        }
    }
}
