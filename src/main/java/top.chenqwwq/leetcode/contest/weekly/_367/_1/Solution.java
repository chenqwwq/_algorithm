package top.chenqwwq.leetcode.contest.weekly._367._1;

/**
 * @author chenqwwq
 * @date 2023/10/15
 **/
public class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + indexDifference; j < n; j++) {
                if (Math.abs(nums[j] - nums[i]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}