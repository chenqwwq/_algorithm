package top.chenqwwq.leetcode.biweek._50._1;

/**
 * @author chen
 * @date 2021/4/17
 **/
public class Solution {
    public int minOperations(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int ans = 0, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                min = nums[i];
            } else {
                ans += min++ - nums[i] + 1;
            }
        }
        return ans;
    }
}
