package top.chenqwwq.leetcode.weekly._233._1;

/**
 * @author chen
 * @date 2021/3/21
 **/
public class Solution {
    public int maxAscendingSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
                continue;
            }
            ans = Math.max(ans, sum);
            sum = nums[i];
        }

        return Math.max(ans, sum);
    }
}