package top.chenqwwq.leetcode.daily._2026._20260502;

/**
 * @author chenqwwq
 * @date 2026/5/2
 **/
public class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += check(i) ? 1 : 0;
        }
        return ans;
    }

    boolean check(int n) {
        boolean e1 = true, e2 = false;
        while (n != 0) {
            int t = n % 10;
            e1 = e1 && (t == 0 || t == 1 || t == 8 || t == 2 || t == 5 || t == 6 || t == 9);
            e2 = e2 || (t == 2 || t == 5 || t == 6 || t == 9);
            n /= 10;
        }
        return e1 && e2;
    }
}