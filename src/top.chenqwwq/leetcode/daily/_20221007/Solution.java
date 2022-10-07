package top.chenqwwq.leetcode.daily._20221007;

/**
 * @author chenqwwq
 * @date 2022/10/7
 **/
public class Solution {
    public int maxAscendingSum(int[] nums) {
        final int n = nums.length;
        int sum = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) sum += nums[i];
            else sum = nums[i];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}