package top.chenqwwq.leetcode.weekly._198._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5465. 子树中标签相同的节点数 显示英文描述
 * 给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）
 * <p>
 * 边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。
 * <p>
 * 返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。
 * <p>
 * 树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。
 *
 * @author chen
 * @date 2020/7/19 上午10:57
 */
public class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // 表示节点
        List<List<Integer>> node = new ArrayList<>();
        final char[] chars = labels.toCharArray();

        boolean[] visit = new boolean[n];
        visit[0] = true;

        for (int i = 0; i < n; i++) {
            node.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            if (visit[i[0]]) {
                node.get(i[0]).add(i[1]);
                visit[i[1]] = true;
            } else {
                node.get(i[1]).add(i[0]);
                visit[i[0]] = true;
            }
        }

        // 构造出来单向的node

        // map的key - value表示向下遍历的过程中chars[i]出现了几次
        final HashMap<Integer, Integer> map = new HashMap<>(n);
        dfs(chars, node, 0, map);

        int[] res = new int[n];
        for (Integer key : map.keySet()) {
            res[key] = map.get(key);
        }

        return res;
    }

    private void dfs(char[] chars, List<List<Integer>> nodes, int i, Map<Integer, Integer> map) {
        if (i > nodes.size()) {
            return;
        }
        map.put(i, 1);
        for (Integer o : map.keySet()) {
            if (o != i && chars[o] == chars[i]) {
                map.put(o, map.get(o) + 1);
            }
        }
        for (Integer node : nodes.get(i)) {
            dfs(chars, nodes, node, map);
        }
    }
}
