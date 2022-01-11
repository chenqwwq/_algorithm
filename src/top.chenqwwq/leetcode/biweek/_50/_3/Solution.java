package top.chenqwwq.leetcode.biweek._50._3;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/4/17
 **/
public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int base = (int) Math.pow(2, maximumBit) - 1;
        int[] ans = new int[nums.length];
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr ^= nums[i];
            ans[nums.length - 1 - i] = curr ^ base;
        }

        return ans;
    }
}
