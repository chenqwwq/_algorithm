package top.chenqwwq.leetcode.contest.biweek._105._3;

import java.util.Arrays;

/**
 * @author 沽酒
 * @since 2023/05/29
 */
public class Solution {
    public long maxStrength(int[] nums) {
        final int n = nums.length;
        if(n == 1) return nums[0];
        Arrays.sort(nums);
        long ans = 1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                ans *= nums[i];
                flag = true;
            } else if (nums[i] < 0 && i < n - 1 && nums[i + 1] < 0) {
                ans *= (long) nums[i] * nums[++i];
                flag = true;
            }
        }
        return flag ? ans : 0 ;
    }
}
