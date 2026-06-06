package top.chenqwwq.leetcode.daily._2022._20221110;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/11/10
 **/
public class Solution {
    int N = 31, K = 7;
    // 在 [i,j] 状态为 status 下的行进步数
    int[][][] dist = new int[N][N][1 << 6];
    int INF = 0x3f3f3f3f;

    int[] cx = new int[]{0, 0, 1, -1};
    int[] cy = new int[]{1, -1, 0, 0};

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean match(char c, int stat) {
        return ((stat >> (c - 'A')) & 1) == 1;
    }


    public int shortestPathAllKeys(String[] grid) {
        final int n = grid.length, m = grid[0].length();
        int total = 0;          // 钥匙总数
        // 常规 BFS 但是需要保存每个状态下统计的信息
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], INF);
                char c = grid[i].charAt(j);
                if (c == '@') {
                    deque.add(new int[]{i, j, 0});
                    dist[i][j][0] = 0;
                } else if (isKey(c)) total++;
            }
        }
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0], y = cur[1], stat = cur[2];
            int step = dist[x][y][stat];
            for (int i = 0; i < 4; i++) {
                int a = x + cx[i], b = y + cy[i];
                char c;
                if (a < 0 || b < 0 || a >= n || b >= m || (c = grid[a].charAt(b)) == '#') continue;  // 越界
                if (isLock(c) && !match(c, stat)) continue;     // 是锁并且没有钥匙 -> 退出
                int ts = stat;
                if (isKey(c)) ts |= (1 << (c - 'a'));         // 是钥匙 -> 更新状态
                if (ts == (1 << total) - 1) return step + 1;    // 已经收集到所有钥匙
                if (step + 1 >= dist[a][b][ts]) continue;       // 不是最短路径
                dist[a][b][ts] = step + 1;                      // 更新当前最短路径
                deque.addLast(new int[]{a, b, ts});             // 添加到队列下次遍历
            }
        }
        return -1;
    }
}