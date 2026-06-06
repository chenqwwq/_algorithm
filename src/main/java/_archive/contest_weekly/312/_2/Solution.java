package top.chenqwwq.leetcode.contest.weekly._312._2;

/**
 * @author chenqwwq
 * @date 2022/9/25
 **/
public class Solution {
    public int longestSubarray(int[] nums) {
        final int n = nums.length;
        int max = -1, len = 0;
        int ans = 0;
        for (int num : nums) max = Math.max(max, num);
        for (int num : nums) {
            if (num != max) len = 0;
            if (num == max) len++;
            ans = Math.max(len,ans);
        }
        return ans;
    }
}