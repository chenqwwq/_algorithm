package top.chenqwwq.leetcode.contest.weekly._unknow._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2023/8/6
 **/
public class Solution {
    int[] cx = {0, 0, 1, -1};
    int[] cy = {1, -1, 0, 0};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        final int n = grid.size();
        if (grid.get(0).get(0) == 1) return 0;
        List<int[]> nodes = new ArrayList<>();
        int[][] dd = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dd[i],Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    nodes.add(new int[]{i, j});
                    dd[0][0] = Math.min(dd[0][0], i + j);
                }
            }
        }


        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[2], o1[2]));
        queue.add(new int[]{0, 0, dd[0][0]});

        while (!queue.isEmpty()) {
            final int[] p = queue.poll();
            int x = p[0], y = p[1], d = p[2];
            for (int i = 0; i < 4; i++) {
                int xx = x + cx[i], yy = y + cy[i];
                if (xx < 0 || yy < 0 || xx >= n || yy >= n || vis[xx][yy]) continue;
                if(dd[xx][yy] == Integer.MAX_VALUE) dd[xx][yy] = getDis(nodes,xx,yy);
                if (xx == n - 1 && yy == n - 1) return Math.min(d, dd[xx][yy]);
                int t = Math.min(d, dd[xx][yy]);
                vis[xx][yy] = true;
                if (t == 0) continue;
                queue.add(new int[]{xx, yy, t});
            }
        }
        return 0;
    }

    public int getDis(List<int[]> nodes, int x, int y) {
        int dis = Integer.MAX_VALUE;
        for (int[] node : nodes) {
            dis = Math.min(dis, Math.abs(x - node[0]) + Math.abs(y - node[1]));
        }
        return dis;
    }


}