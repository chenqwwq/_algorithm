package top.chenqwwq.leetcode.contest.weekly._297._1;

/**
 * @author chenqwwq
 * @date 2022/6/12
 **/
public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int n = brackets.length;
        double ans = 0;
        for (int i = 0; i < n && income > 0; i++) {
            int cur = Math.min(income, i - 1 >= 0 ? brackets[i][0] - brackets[i - 1][0] : brackets[i][0]);
            ans += 1d * cur * brackets[i][1] / 100d;
            income -= cur;
        }
        return ans;
    }
}