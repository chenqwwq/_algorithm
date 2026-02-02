package top.chenqwwq.leetcode.daily._2025._20251116;

/**
 * @author chenqwwq
 * @date 2025/11/16
 **/
public class Solution {

    int mod = (int) 1e9 + 7;

    private long h(int n) {
        long ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += i;
        }
        return ret % mod;
    }

    public int numSub(String s) {
        long ans = 0;
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cur++;
            else {
                if (cur != 0) ans = (ans + h(cur)) % mod;
                cur = 0;
            }
        }
        return (int) (ans + h(cur)) % mod;
    }
}