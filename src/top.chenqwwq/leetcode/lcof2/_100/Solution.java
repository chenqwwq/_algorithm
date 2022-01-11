package top.chenqwwq.leetcode.lcof2._100;

import java.util.List;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int n = triangle.size(), m = triangle.get(n - 1).size();
        int[][] dp = new int[n][m];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            final List<Integer> nums = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(j < i ? dp[i - 1][j] : Integer.MAX_VALUE, j >= 1 ? dp[i - 1][j - 1] : Integer.MAX_VALUE) + nums.get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int num : dp[n - 1]) {
            ans = Math.min(num, ans);
        }
        return ans;
    }
}
