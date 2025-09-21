package top.chenqwwq.leetcode.contest.biweek._108._3;

import java.util.HashSet;
import java.util.Set;
import java.util.function.IntBinaryOperator;

/**
 * @author chenqwwq
 * @date 2023/7/8
 **/
public class Solution {

    static Set<Integer> five = new HashSet<>();

    static {
        for (int i = 1; i > 0 && i < Integer.MAX_VALUE; i *= 5) {
            five.add(i);
        }
    }

    static final int INF = 0x3f3f3f3f;
    int ans = INF;

    public int minimumBeautifulSubstrings(String s) {
        if (s.charAt(0) == '0') return -1;
        dfs(s, 0, 0, 0);
        return ans == INF ? -1 : ans;
    }

    public void dfs(String s, int pos, int cur, int cnt) {
        if (pos >= s.length()) {
            ans = Math.min(ans, cur == 0 ? cnt : (five.contains(cur) ? cnt + 1 : INF));
            return;
        }
        int tmp = (cur << 1) + s.charAt(pos) - '0';
        while (++pos < s.length() && s.charAt(pos) == '0') tmp <<= 1;
        dfs(s, pos, tmp, cnt);
        if (five.contains(tmp)) dfs(s, pos, 0, cnt + 1);
    }
}