package top.chenqwwq.leetcode.contest.biweek._87._3;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/17
 **/
public class Solution {
    public int[] smallestSubarrays(int[] nums) {
        final int n = nums.length;
        int[] hash = new int[32], ans = new int[n];
        Arrays.fill(ans, 1);
        Arrays.fill(hash, -1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> j) & 1) == 1) hash[j] = i;
                if (hash[j] == -1) continue;
                ans[i] = Math.max(ans[i], hash[j] - i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().smallestSubarrays(new int[]{1, 0, 2, 1, 3});
    }
}