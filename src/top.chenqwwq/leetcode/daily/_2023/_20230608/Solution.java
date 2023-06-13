package top.chenqwwq.leetcode.daily._2023._20230608;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

/**
 * @author 沽酒
 * @since 2023/06/08
 */
public class Solution {
    int ans;
    int n, m;
    int[] stat;

    public int tilingRectangle(int n, int m) {
        this.ans = n * m;
        stat = new int[n];
        dfs(0, 0, 0);
        return ans;
    }

    public void dfs(int i, int j, int cur) {
        if (i >= n || i < 0 || j >= m || j < 0 || cur >= ans) {
            return;
        }

        // 位置已经被占
        if (((stat[i] >> j) & 1) == 1) {
            if (j + 1 < m) dfs(i, j + 1, cur);
            else dfs(i + 1, 0, cur);
            return;
        }

        int len = 1;
        while (valid(i, j, len)) {
            fill(i, j, len);
            if (j + 1 < m) dfs(i, j + 1, cur + 1);
            else dfs(i + 1, 0, cur + 1);
            fill(i, j, len++);
        }
    }

    private void fill(int i, int j, int len) {
        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                stat[i + x] ^= (1 << (y + j));
            }
        }
    }

    private boolean valid(int i, int j, int len) {
        int x = i + len, y = j + len;
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}