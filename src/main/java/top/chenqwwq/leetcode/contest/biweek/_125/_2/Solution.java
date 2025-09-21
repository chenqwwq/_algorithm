package top.chenqwwq.leetcode.contest.biweek._125._2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2024/3/2
 **/
public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o));
        for (int num : nums) queue.add((long) num);

        int ans = 0;
        while (queue.size() >= 2 && queue.peek() < k) {
            final Long a = queue.poll(),b = queue.poll();
            queue.add(a * 2 + b);
            ans++;
        }
        return ans;
    }
}