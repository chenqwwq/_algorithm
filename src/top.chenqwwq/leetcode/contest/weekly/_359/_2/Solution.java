package top.chenqwwq.leetcode.contest.weekly._359._2;

/**
 * @author chenqwwq
 * @date 2023/8/20
 **/
public class Solution {
    public int minimumSum(int n, int k) {
        int ans = 0, i;
        for (i = 1; i <= k / 2 && i <= n; i++) ans += i;
        while (i++ <= n)ans += k++;
        return ans;
    }
}