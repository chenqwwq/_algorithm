package top.chenqwwq.leetcode.daily._2024._20240726;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/7/26
 **/
public class Solution {
    public int findValueOfPartition(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        int ans = 0x3f3f3f3f;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans,nums[i+1] - nums[i]);
        }
        return ans;
    }
}