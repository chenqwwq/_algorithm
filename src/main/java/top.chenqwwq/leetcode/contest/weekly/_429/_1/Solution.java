package top.chenqwwq.leetcode.contest.weekly._429._1;

/**
 * @author chenqwwq
 * @date 2024/12/22
 **/
public class Solution {
    public int minimumOperations(int[] nums) {
        final int m = nums.length;
        int[] hash = new int[101];
        int cnt = 0, n = nums.length;
        for (int num : nums) {
            if (hash[num]++ == 0) cnt++;
        }

        int ans = 0, idx = 0;
        while (cnt < n) {
            for (int i = 0; i < 3; i++) if (idx < m && hash[nums[idx++]]-- == 1) cnt--;
            n -= 3;
            ans++;
        }
        return ans;
    }
}