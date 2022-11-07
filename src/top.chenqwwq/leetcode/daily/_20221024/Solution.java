package top.chenqwwq.leetcode.daily._20221024;

/**
 * @author chenqwwq
 * @date 2022/10/24
 **/
public class Solution {
    public int partitionDisjoint(int[] nums) {
        final int n = nums.length;
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) min[i] = Math.min(nums[i], min[i + 1]);
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= min[i + 1]) return i+1;
        }
        return -1;
    }
}