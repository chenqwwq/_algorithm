package template.dijkstra;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/11/15
 **/
public class Dijkstra {

    public static final int INF = 0x3f3f3f3f;

    /**
     *
     * @param map  邻接矩阵
     * @param x    源
     * @return 到每个点的距离
     */
    int[] dijkstra(int[][] map, int x) {
        int n = map.length;
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        boolean[] vis = new boolean[n];
        // 到每个点的距离
        int[] dist = new int[n];
        // 都为不可达
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[x] = 0;
        // 有多少个点就迭代多少次
        for (int k = 0; k < n; k++) {
            // 每次找到「最短距离最小」且「未被更新」的点 t
            // 每次只找最短的点
            int t = -1;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && (t == -1 || dist[i] < dist[t])) t = i;
            }
            // 标记点 t 为已更新
            vis[t] = true;
            // 用点 t 的「最小距离」更新其他点
            for (int i = 0; i < n; i++) dist[i] = Math.min(dist[i], dist[t] + map[t][i]);
        }
        return dist;
    }
}
