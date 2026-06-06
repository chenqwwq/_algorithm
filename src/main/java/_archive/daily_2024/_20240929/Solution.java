package top.chenqwwq.leetcode.daily._2024._20240929;

/**
 * @author chenqwwq
 * @date 2024/9/29
 **/
public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        final int n = tickets.length;
        int m = tickets[k], ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(m - (i <= k ? 0 : 1), tickets[i]);
        }
        return ans;
    }
}