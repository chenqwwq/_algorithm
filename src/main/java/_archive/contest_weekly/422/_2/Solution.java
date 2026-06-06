package top.chenqwwq.leetcode.contest.weekly._422._2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenqwwq
 * @date 2024/11/3
 **/
public class Solution {

    int INF = 0x3f3f3f3f;
    int[][] tt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        final int n = moveTime.length, m = moveTime[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, moveTime[0][0]});
        int[][] ts = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ts[i], INF);
        }
        ts[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], y = p[1], cur = p[2];
            for (int i = 0; i < 4; i++) {
                int xx = x + tt[i][0], yy = y + tt[i][1];
                if (xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
                int t = Math.max(cur, moveTime[xx][yy])+1;
                if (t < ts[xx][yy]) {
                    ts[xx][yy] = t;
                    queue.add(new int[]{xx, yy, t});
                }
            }
        }
        return ts[n - 1][m - 1];
    }
}