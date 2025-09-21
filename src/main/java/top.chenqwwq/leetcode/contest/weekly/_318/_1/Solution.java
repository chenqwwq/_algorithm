package top.chenqwwq.leetcode.contest.weekly._318._1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/11/7
 **/
public class Solution {
    public int[] applyOperations(int[] nums) {
        final int n = nums.length;
        for(int i = 0;i < n-1;i++){
            if(nums[i] == nums[i+1]) {
                nums[i] <<= 1;
                nums[i+1] = 0;
            }
        }
        int[] ans = new int[n];
        for(int i = 0,j = 0;i < n;i++){
            if(nums[i] != 0) ans[j++] = nums[i];
        }
        return ans;
    }
}