package top.chenqwwq.leetcode.contest.biweek._172._1;

/**
 * @author chenqwwq
 * @date 2025/12/20
 **/
public class Solution {
    public int minOperations(int[] nums) {
        final int n = nums.length;
        boolean[] vis = new boolean[100001];
        for (int i = n - 1; i >= 0; i--) {
            if (vis[nums[i]]) {
                return (i + 1) % 3 == 0 ? i / 3 : (i / 3 + 1);
            }
            vis[nums[i]] = true;
        }
        return 0;
    }
}