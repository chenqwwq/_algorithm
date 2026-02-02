package top.chenqwwq.leetcode.contest.weekly._476._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/11/16
 **/
public class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] + nums[nums.length - 2] - nums[0];
    }
}