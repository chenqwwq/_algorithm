package top.chenqwwq.leetcode.contest.weekly._376._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/12/17
 **/
public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        final int n = nums.length;
        int[][] ans = new int[n / 3][3];
        Arrays.sort(nums);
        for (int i = 0; i < n / 3; i++) {
            final int[] ns = new int[3];
            ns[0] = nums[i * 3];
            for (int j = 1; j < 3; j++) {
                ns[j] = nums[i * 3 + j];
                if(ns[j] - ns[0] > k) return new int[][]{};
            }
            ans[i] = ns;
        }
        return ans;
    }
}