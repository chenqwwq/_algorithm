package top.chenqwwq.leetcode.contest.biweek._93._3;

/**
 * @author chenqwwq
 * @date 2022/12/13
 **/
public class Solution {
    public int maxJump(int[] stones) {
        final int n = stones.length;
        if (n == 2) return stones[1] - stones[0];

        int ans = stones[1] - stones[0];
        for (int i = 2; i < n; i++) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }
        return ans;
    }
}