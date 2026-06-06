package top.chenqwwq.pat.advanced._1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 上一个题解最后一个用例一直超时，尝试用并查集写
 *
 * @author chen
 * @date 2021/4/11
 **/
public class Main_UnionFind {
    static int[][] highways;
    static int[] uf;
    public static void main(String[] args) throws IOException {
        // 基础数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = reader.readLine().split(" ");
        final int n = Integer.parseInt(line[0]),
                m = Integer.parseInt(line[1]),
                k = Integer.parseInt(line[2]);
        uf = new int[n];
        highways = new int[m][2];

        // 读取道路信息
        for (int i = 0; i < m; i++) {
            final String[] data = reader.readLine().split(" ");
            highways[i] = new int[]{Integer.parseInt(data[0]) - 1, Integer.parseInt(data[1]) - 1};
        }

        final String[] occupy = reader.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            // 需要抛除的节点
            final int city = Integer.parseInt(occupy[i]) - 1;

            // 重新初始化并查集
            for (int j = 0; j < n; j++) {
                uf[j] = j;
            }

            // 联合
            for (int[] highway : highways) {
                if (highway[0] == city || highway[1] == city) {
                    continue;
                }
                if (find(highway[0]) != find(highway[1])) {
                    uf[highway[0]] = highway[1];
                }
            }

            // 查询连通分量
            int cnt = 0;
            for (int c = 0; c < n; c++) {
                if (c != city && uf[c] == c) {
                    cnt++;
                }
            }
            // 每两个分量之间需要一条线路合并,单分量不需要线路
            System.out.printf("%d\n", cnt - 1);

        }
    }

    /**
     * 带压缩路径的find
     */
    static int find(int n) {
        if (uf[n] != n) {
            uf[n] = find(uf[n]);
        }
        return uf[n];
    }
}
