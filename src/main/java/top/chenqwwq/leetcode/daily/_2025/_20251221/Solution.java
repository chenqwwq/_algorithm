package top.chenqwwq.leetcode.daily._2025._20251221;

/**
 * @author chenqwwq
 * @date 2025/12/21
 **/
public class Solution {
    public int minDeletionSize(String[] strs) {
        final int n = strs.length, m = strs[0].length();
        int ans = 0;
        boolean[] ok = new boolean[n];      // 每一行和下面的行是否已经符合
        outer:
        for (int i = 0; i < m; i++) {       // 每一列
            boolean[] tok = new boolean[n];
            for (int j = 0; j < n - 1; j++) {
                if (ok[j]) continue;
                final char a = strs[j].charAt(i), b = strs[j + 1].charAt(i);
                if (a > b) {
                    ans++;
                    continue outer;
                } else if (a < b) tok[j] = true;
            }

            for (int q = 0; q < n; q++) {
                ok[q] |= tok[q];
            }
        }
        return ans;
    }
}