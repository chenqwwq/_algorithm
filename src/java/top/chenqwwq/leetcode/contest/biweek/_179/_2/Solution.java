package top.chenqwwq.leetcode.contest.biweek._179._2;

/**
 * @author chenqwwq
 * @date 2026/3/29
 **/
public class Solution {
    int mod = (int) (1e9 + 7);

    public int countVisiblePeople(int n, int pos, int k) {
        int l = n - pos - 1, r = n - l - 1;     // 左右两边的数量
        return 1;
    }

    public int c(int a, int b) {
        // a 个位置选 b 个人
        long ans = 1;
        for (int i = 1; i <= b; i++) {
            ans = ans * i % mod;
        }
        for (int i = 2; i <= a; i++) {
            ans /= i;
        }
        return (int) ans;
    }
}