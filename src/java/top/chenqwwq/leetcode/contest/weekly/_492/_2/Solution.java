package top.chenqwwq.leetcode.contest.weekly._492._2;

/**
 * @author chenqwwq
 * @date 2026/3/8
 **/
public class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        final int n = nums.length;
        double cl = sum, cr = 1;
        for (int i = n - 1; i >= 0; i--) {
            cl -= nums[i];
            if (i < n - 1) cr *= nums[i + 1];
            if (cl == cr) return i;
        }
        return -1;
    }
}