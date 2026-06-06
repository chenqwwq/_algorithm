package top.chenqwwq.pat.advanced._1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/4/11
 **/
public class Main {

    /**
     * 用boolean数组表示无向无权图片
     */
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        // 题目的意思就是求出缺少一个顶点之后，连接所有的城市需要的道路数
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = reader.readLine().split(" ");

        // n 代表城市数目
        // m 代表剩余的铁路
        // k 代表
        final int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]), k = Integer.parseInt(line[2]);
        graph = new boolean[n][n];

        // 读取图的信息
        for (int i = 0; i < m; i++) {
            final String[] data = reader.readLine().split(" ");
            final int x = Integer.parseInt(data[0]) - 1;
            final int y = Integer.parseInt(data[1]) - 1;
            graph[x][y] = graph[y][x] = true;
        }

        // 分析连通分量
        final String[] concernCity = reader.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            boolean[] marked = new boolean[n];
            final int concern = Integer.parseInt(concernCity[i]) - 1;
            // marked 表示是否已经访问的标记
            // 跳过关心的节点，因为city 是 1~N的 所以减去1
            marked[concern] = true;
            int cnt = 0;
            // 处理所有的节点
            for (int q = 0; q < n; q++) {
                if (!marked[q]) {
                    // 深度搜索将其连接的全部标记
                    dfs(marked, q);
                    cnt++;
                }
            }
            System.out.printf("%d\n", cnt - 1);
        }
    }

    public static void dfs(boolean[] marked, int n) {
        // 遍历整张图,求出所有相连的顶点
        marked[n] = true;
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i] && graph[n][i]) {
                dfs(marked, i);
            }
        }
    }
}
