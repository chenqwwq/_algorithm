package top.chenqwwq.leetcode.archive.lcp._2022.group._2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2022/4/25
 **/
public class Solution {
    static class Point {
        int val;
        int x, y;

        public Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    char[] direction = {'^', 'v', '<', '>'};
    int[] cx = {-1, 1, 0, 0}, cy = {0, 0, -1, 1};
    int INF = 0x3f3f3f3f;

    public int conveyorBelt(String[] M, int[] S, int[] E) {
        int n = M.length, m = M[0].length();
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = INF;
            }
        }


        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        pq.add(new Point(0, S[0], S[1]));
        while (!pq.isEmpty()) {
            final Point poll = pq.poll();
            final int x = poll.x, y = poll.y, val = poll.val;
            if (dis[x][y] != INF) {
                continue;
            }
            dis[x][y] = val;
            for (int i = 0; i < 4; i++) {
                int a = x + cx[i], b = y + cy[i];
                if (a < 0 || b < 0 || a >= n || b >= m) {
                    continue;
                }
                pq.add(new Point(val + (M[x].charAt(y) == direction[i] ? 0 : 1), a, b));
            }
        }
        return dis[E[0]][E[1]];
    }
}