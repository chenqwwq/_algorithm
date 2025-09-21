package top.chenqwwq.leetcode.topic.search.dfs._514;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 沽酒
 * @since 2022/06/30
 */
public class Solution {

    // 记忆化递归
    // 无法简单决定当前步应该如何旋转,如果有两个或者三个相同的字符,当前步会影响后序的消耗,
    // 当前最优无法推导初全局最优,所以无法贪心
    // 记忆化递归，memo[i][j] 表示当前 ring[i] 对着12点的时候，转到 key[j]

    int[][] memo;
    int n, m;
    List<Integer>[] map = new ArrayList[26];
    {
        for (int i = 0; i < 26; i++) {
            map[i] = new ArrayList<>();
        }
    }

    public int findRotateSteps(String ring, String key) {
        n = ring.length();
        m = key.length();
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[ring.charAt(i) - 'a'].add(i);
        }

        return dfs(key, 0, 0);
    }

    private int dfs(String key, int i, int j) {
        if (j >= m) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        char c = key.charAt(j);
        for (int next : map[c - 'a']) {
            int step = Math.abs(next - i);
            res = Math.min(res, dfs(key, next, j + 1) + Math.min(step + 1, n - step + 1));
        }
        return memo[i][j] = res;
    }
}