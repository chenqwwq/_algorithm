package top.chenqwwq.leetcode.contest.weekly._349._1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/6/11
 **/
public class Solution {
    public int findNonMinOrMax(int[] nums) {
        final int n = nums.length;
        if (n < 2) return -1;
        Arrays.sort(nums);
        if(nums[0] == nums[n-1]) return -1;
        for (int i = 1; i < n - 1; i++) {
           if(nums[i] != nums[0] && nums[i] != nums[n-1]) return nums[i];
        }
        return -1;
    }
}