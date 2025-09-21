package top.chenqwwq.leetcode.daily._2023._20231001;

/**
 * @author chenqwwq
 * @date 2023/10/1
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];
        int ans = 0;
        for(int i = 1;i < n;i++){
            dp[i] = Math.min(prices[i],dp[i-1]);
            ans = Math.max(ans,prices[i] - dp[i-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{7,1,5,3,6,4});
    }
}