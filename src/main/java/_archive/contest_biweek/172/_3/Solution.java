package top.chenqwwq.leetcode.contest.biweek._172._3;

import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2025/12/20
 **/
public class Solution {
    public long maximumScore(int[] nums, String s) {
        final int n = s.length();
        long ans = 0;
        PriorityQueue<Integer> ns = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            ns.add(nums[i]);
            if (s.charAt(i) == '1') {
                ans += ns.poll();
            }
        }
        return ans;
    }
}