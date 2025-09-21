package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author CheNbXxx
 * @description 题目主要考虑堆排序，
 * @email chenbxxx@gmail.con
 * @date 2019/1/15 10:16
 */
public class LeetCode703 {
    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(2);
        for (int i = 4; i > 0; i--) {
            integers.offer(i);
        }

        System.out.println(Arrays.toString(integers.toArray()));
    }

    static class KthLargest {

        private final PriorityQueue<Integer> priorityQueue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.priorityQueue = new PriorityQueue<>(k);
            // 因为要指定大小，元素只能逐个添加
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            // 需要自己控制堆的大小
            if (priorityQueue.size() < k) {
                priorityQueue.offer(val);
            } else if (priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
            return priorityQueue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
