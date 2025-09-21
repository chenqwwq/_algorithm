package top.chenqwwq.leetcode.contest.weekly._439._1;

import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/2
 **/
public class Solution {
    int N = 51;

    public int largestInteger(int[] nums, int k) {
        final int n = nums.length;
        int[] hash = new int[N];

        for (int i = 0; n - i >= k; i++) {
            int[] vis = new int[N];
            for (int j = 0; j < k; j++) {
                if (++vis[nums[i + j]] == 1) {
                    hash[nums[i + j]]++;
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (hash[i] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().largestInteger(new int[]{0, 0}, 2);
    }
}