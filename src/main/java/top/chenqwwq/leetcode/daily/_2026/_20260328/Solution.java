package top.chenqwwq.leetcode.daily._2026._20260328;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/28
 **/
public class Solution {

    public String findTheString(int[][] lcp) {
        final int n = lcp.length;
        final char[] cs = new char[n];
        Arrays.fill(cs, '#');
        char c = 'a';
        for (int i = 0; i < n; i++) {
            if (cs[i] != '#') continue;
            boolean cover = false;
            for (int j = i; j < n; j++) {
                if (lcp[i][j] == 0) continue;
                if (c > 'z') return "";
                cs[j] = c;
                cover = true;
            }
            if (cover) {
                c++;
            }
        }

        // 验证一下
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j && lcp[i][j] != n - i) return "";
                int x = i, y = j, cnt = lcp[i][j];
                for (; x < n && y < n; x++, y++) {
                    if (cs[x] != cs[y]) break;
                    cnt--;
                }
                if (cnt != 0) return "";
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }
        return new String(cs);
    }
}