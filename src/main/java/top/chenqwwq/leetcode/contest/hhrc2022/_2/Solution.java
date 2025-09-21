package top.chenqwwq.leetcode.contest.hhrc2022._2;

/**
 * @author chenqwwq
 * @date 2022/10/4
 **/
public class Solution {
    public int longestESR(int[] sales) {
        final int n = sales.length;
        int[] dp = new int[n];
        dp[0] = sales[0] > 8 ? 1 : 0;
        return -1;
    }

    public static void main(String[] args) {
        new Solution().longestESR(new int[]{10, 2, 1, 4, 3, 9, 6, 9,});
    }
}