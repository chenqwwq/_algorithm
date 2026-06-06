package top.chenqwwq.leetcode.contest.biweek._104._2;

import java.util.Arrays;

/**
 * @author 沽酒
 * @since 2023/05/17
 */
public class Solution {
    public int matrixSum(int[][] nums) {
        final int n = nums.length, m = nums[0].length;
        int[] max = new int[m];
        for (int[] ns : nums) {
            Arrays.sort(ns);
            for (int i = 0; i < m; i++) {
                max[i] = Math.max(max[i], ns[i]);
            }
        }
        int ans = 0;
        for(int num : max){
            ans += num;
        }
        return ans;
    }
}