package top.chenqwwq.leetcode.contest.biweek._92._3;

/**
 * @author chenqwwq
 * @date 2022/11/27
 **/
public class Solution {
    public int bestClosingTime(String customers) {
        final int n = customers.length();
        int[] sum = new int[n];
        sum[0] = getCnt(customers.charAt(0));
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + getCnt(customers.charAt(i));
        }

        int ans = 0, cur = sum[n - 1];
        for (int i = 1; i < n; i++) {
            int tmp = sum[n - 1] - sum[i - 1] + (i - sum[i - 1]);
            if (tmp < cur) {
                ans = i;
                cur = tmp;
            }
        }
        return  n - sum[n-1] < cur ? n : ans;
    }

    private int getCnt(char c) {
        return c == 'Y' ? 1 : 0;
    }
}