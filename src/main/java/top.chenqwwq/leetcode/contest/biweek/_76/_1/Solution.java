package top.chenqwwq.leetcode.contest.biweek._76._1;

/**
 * @author chenqwwq
 * @date 2022/4/16
 **/
public class Solution {
    public int findClosestNumber(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i]) < Math.abs(ans) || (Math.abs(nums[i]) == Math.abs(ans) && nums[i] > ans)) {
                ans = nums[i];
            }
        }
        return ans;
    }
}