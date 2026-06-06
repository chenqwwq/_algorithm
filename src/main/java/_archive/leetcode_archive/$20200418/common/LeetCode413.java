package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 413. Arithmetic Slices,等差数列的划分
 *
 * @author chen
 * @date 19-7-10 下午11:12
 */
public class LeetCode413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            // 动态规划解决
            // 每多一个数字,等差数组数量就多原来数组长度个
            // 对于nums[i]来说表示nums[i-1]的等差数组个数
            // dp  = dp + 1;
            int dp = 0, sum = 0;

            // 找到第一个等差数组
            for (int i = 2; i < A.length; i++) {
                if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                    // 表示为等差数列
                    sum += ++dp;
                } else {
                    // 清空
                    dp = 0;
                }
            }

            return sum;
        }
    }
}
