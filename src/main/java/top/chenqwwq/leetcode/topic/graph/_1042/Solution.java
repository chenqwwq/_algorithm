package top.chenqwwq.leetcode.topic.graph._1042;

import java.util.LinkedList;

/**
 * 1042. 不邻接植花
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 * <p>
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 * <p>
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 *
 * @author chen
 * @date 2020/7/4 下午10:13
 */
public class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        // 按照题目意思理解
        // paths 就是图的边，N就是节点个数
        // 我们需要做的就是将相连的节点染成不同颜色
        // 可以使用邻接表的形式，存一个节点和与其相连的所有节点

        // 初始的时候所有的节点都为0
        // 返回值
        int[] node = new int[N];

        // 初始化邻接表
        // graph[i]就是表示第i个节点的所有邻接节点
        LinkedList<Integer>[] graph = new LinkedList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }

        // 遍历所有节点
        outer:
        for (int i = 1; i <= N; i++) {
            // 遍历所有的节点
            // colors[i]表示i+1的花是否已经种了
            boolean[] colors = new boolean[4];
            // 遍历所有关联节点
            for (int j : graph[i]) {
                // j表示j-1的花已经种过了
                if (node[j - 1] != 0) {
                    colors[node[j - 1] - 1] = true;
                }
            }

            // 遍历colors
            for (int idx = 0; idx < colors.length; idx++) {
                // 找到第一个false的
                if (!colors[idx]) {
                    node[i - 1] = idx + 1;
                    continue outer;
                }
            }
        }

        return node;
    }
}
