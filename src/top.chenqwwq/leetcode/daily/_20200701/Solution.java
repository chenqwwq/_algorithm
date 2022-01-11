package top.chenqwwq.leetcode.daily._20200701;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100*
 *
 * @author chen
 * @date 2020-07-01
 **/
public class Solution {
    public int findLength(int[] A, int[] B) {
        // 很明显的动态规划
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }


        // 状态转移方程如下:
        // dp[i][j] = A[i] == B[j] ? dp[i-1][j-1] + 1 : 0
        int[][] dp = new int[A.length + 1][B.length + 1];
        int res = 0;
        // 初始条件
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                dp[i + 1][j + 1] = A[i] == B[j] ? dp[i][j] + 1 : 0;
                res = Math.max(dp[i + 1][j + 1], res);
            }
        }

        return res;
    }
}
