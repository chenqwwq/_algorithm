package top.chenqwwq.leetcode.contest.biweek._146._1;

/**
 * @author chenqwwq
 * @date 2024/12/21
 **/
public class Solution {
    public int countSubarrays(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if ((double) nums[i] + nums[i + 2] == (double) nums[i + 1] / 2) {
                ans++;
            }
        }
        return ans;
    }
}