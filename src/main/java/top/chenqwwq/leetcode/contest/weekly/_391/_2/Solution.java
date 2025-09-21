package top.chenqwwq.leetcode.contest.weekly._391._2;

/**
 * @author chenqwwq
 * @date 2024/3/31
 **/
public class Solution {
    public int maxBottlesDrunk(int n, int m) {
        if (n == 0) return 0;
        int ans = 0;
        ans += n;
        while (n >= m) {
            ans++;
            n = n - m++ + 1;
        }
        return ans;
    }
}