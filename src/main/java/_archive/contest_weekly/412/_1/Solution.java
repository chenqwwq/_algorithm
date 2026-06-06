package top.chenqwwq.leetcode.contest.weekly._412._1;

/**
 * @author chenqwwq
 * @date 2024/8/25
 **/
public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        final int n = nums.length;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE, idx = -1;
            for (int j = 0; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }
            nums[idx] *= multiplier;
        }
        return nums;
    }
}