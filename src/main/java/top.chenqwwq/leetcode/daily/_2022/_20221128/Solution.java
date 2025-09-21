package top.chenqwwq.leetcode.daily._2022._20221128;

/**
 * @author chenqwwq
 * @date 2022/11/28
 **/
public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        // 初步考虑2分或者异步 结果为小数可能不能异步
        final int n = nums.length;

        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + nums[i];

        // dp[i][j] 表示 前j个数字分成i组的最大值
        double[][] dp = new double[k][n];
        // 最大的平均值
        for (int i = 1; i < n; i++) dp[0][i] = i;
        // 1. 独立一组
        // 2. 和前面合并为一组
        for (int i = 2; i < k; i++) {
            for (int j = i - 1; j < n; j++) {
            }
        }
        return 0;
    }
}