package template.floyd;

/**
 * 多源汇最短路径
 *
 * @author chenqwwq
 * @date 2023/11/15
 **/
public class Floyd {
    public static void floyd(int[][] g) {
        int n = g.length;
        // floyd 基本流程为三层循环: [枚举中转点 - 枚举起点 - 枚举终点] => 松弛操作

        // 外层为中间节点
        for (int p = 0; p < n; p++) {
            // 中间为起点
            for (int i = 0; i < n; i++) {
                // 内层为终点
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][p] + g[p][j]);
                }
            }
        }
    }
}
