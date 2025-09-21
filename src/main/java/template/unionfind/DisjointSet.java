package template.unionfind;

import java.util.Arrays;

/**
 * 并查集的Java数组实现
 *
 * @author chen
 * @date 2020/7/13 下午10:17
 */
public class DisjointSet {
    /**
     * 底层保存形式,tree[i]表示第i个节点的父节点,-1表示为顶级节点
     */
    private int[] tree;

    public DisjointSet(int n) {
        this.tree = new int[n];
        Arrays.fill(tree, -1);
    }

    public int root(int n) {
        int node = n;
        while (tree[node] != -1) node = tree[node];
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
