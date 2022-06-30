package top.chenqwwq.leetcode.topic.dp._514;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 沽酒
 * @since 2022/06/30
 */
public class Solution {

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
        for (int i = 0; i < n; i++) {
            map[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0x3f3f3f3f;
            }
        }
        for (int next : map[key.charAt(0) - 'a']) {
            dp[next][0] = Math.min(dp[next][0], Math.min(next, n - next) + 1);
        }
        // 转到 key 的i位
        for (int i = 1; i < m; i++) {
        }
    }
}