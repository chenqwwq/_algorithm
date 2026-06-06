package top.chenqwwq.leetcode.topic.union_find._959;

import java.util.Arrays;

/**
 * 959. 由斜杠划分区域
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * <p>
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * <p>
 * 返回区域的数目。
 *
 * @author chen
 * @date 2020/7/13 下午10:45
 */
public class Solution {
    public int regionsBySlashes(String[] grid) {
        // 娘的 题目意思理解了半天
        // 根据每个小方块建立整体的并查集

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid[0].length();

        DisjointSet tree = new DisjointSet(n * n * 4);

        int q = n * 4 + 1;

        for (int i = 0, k = 0; i < grid.length; i++) {
            final char[] arr = grid[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                final char c = arr[j];
                if (c == '/' || c == ' ') {
                    tree.union(k, k + 1);
                    tree.union(k + 2, k + 3);
                }
                if (c == '\\' || c == ' ') {
                    tree.union(k + 1, k + 2);
                    tree.union(k, k + 3);
                }
                // 不是最右边的话就和右边的连通
                if (i != n - 1) {
                    tree.union(k + 3, k + q);
                }

                if (j != n - 1) {
                    tree.union(k + 2, k + 4);
                }

                k += 4;
            }
        }

        int ans = 0;
        for (int i : tree.tree) {
            if (i == -1) {
                ans++;
            }
        }

        return ans;
    }

    public class DisjointSet {
        int[] tree;

        public DisjointSet(int n) {
            this.tree = new int[n];
            Arrays.fill(tree, -1);
        }

        public int root(int n) {
            // 找到x节点的根节点
            int node = n;
            while (tree[node] != -1) {
                node = tree[node];
            }
            return node;
        }

        public void union(int x, int y) {
            int xRoot = root(x);
            int yRoot = root(y);
            if (xRoot != yRoot) {
                tree[xRoot] = yRoot;
            }
        }


    }

}

