package top.chenqwwq.leetcode.daily._20200716;

/**
 * 785. 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * <p>
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * <p>
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * 注意:
 * <p>
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/16 下午10:04
 */
public class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length <= 2) {
            return true;
        }

        // 记录节点颜色
        // 记忆化递归
        int[] node = new int[graph.length];

        for (int i = 0; i < node.length; i++) {
            if (node[i] == 0) {
                if (!dfs(i, 1, node, graph)) {
                    return false;
                }
            }
        }

        return true;
    }


    private boolean dfs(int i, int color, int[] node, int[][] graph) {
        node[i] = color;
        int t = color * -1;

        for (int n : graph[i]) {
            if (node[n] == color) {
                return false;
            }
            if (node[n] == 0) {
                if (!dfs(n, t, node, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
}
