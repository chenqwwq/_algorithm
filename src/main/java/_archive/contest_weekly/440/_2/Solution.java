package top.chenqwwq.leetcode.contest.weekly._440._2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author chenqwwq
 * @date 2025/3/9
 **/
public class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        final int n = nums2.length;
        Integer[] ns = new Integer[n];
        for (int i = 0; i < n; i++) ns[i] = i;
        Arrays.sort(ns, Comparator.comparingInt(a -> nums1[a]));

        long[] ans = new long[n];
        long cur = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums1[ns[i]] <= nums1[ns[i - 1]]) {
                ans[ns[i]] = ans[ns[i - 1]];
            } else {
                ans[ns[i]] = !queue.isEmpty() ? cur : 0;
            }
            cur += nums2[ns[i]];
            queue.offer(nums2[ns[i]]);
            while (queue.size() > k) {
                cur -= queue.poll();
            }
        }
        return ans;
    }
}