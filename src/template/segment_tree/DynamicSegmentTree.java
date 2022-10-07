package template.segment_tree;

import java.util.function.BiFunction;

/**
 * 动态开点线段树，在没有值域范围很大并且无法映射到小片范围的时候可以采用该类
 * （对于 0 ～ 1e9 的数据范围 4*n 的范围明显不可接受
 * 如果是离线查询可以使用离散化处理所有数据尽量将数据范围收缩，在线大范围必须使用动态开点
 *
 * @author chenqwwq
 * @date 2022/6/6
 **/
public class DynamicSegmentTree {
    private static final class Node {
        Node lc, rc; // 左右子节点
        int add, data; // 懒标记和真实数据
    }

    public static final int N = (int) 1e9 + 7;
    private final Node root;

    public DynamicSegmentTree() {
        this.root = new Node();
    }

    // 区间更新

    public void update(int l, int r, int v) {
        update(root, 0, N, l, r, v);
    }

    private void update(Node node, int ll, int rr, int l, int r, int v) {
        if (l <= ll && rr <= r) {
            node.data += v;
            node.add += v;
            return;
        }
        lazyCreate(node);
        pushDown(node);
        int mid = ll + ((rr - ll) >> 1);
        if (l <= mid) update(node.lc, ll, mid, l, r, v);
        if (r > mid) update(node.rc, mid + 1, rr, l, r, v);
        pushUp(node);
    }

    // 区间查询

    public int query(int l, int r) {
        return query(root, 0, N, l, r);
    }

    private int query(Node node, int ll, int rr, int l, int r) {
        if (l <= ll && r >= rr) return node.data;
        lazyCreate(node);
        pushDown(node);
        int mid = ll + ((rr - ll) >> 1);
        int ans = 0;
        if (l <= mid) ans = query(node.lc, ll, mid, l, r);
        if (mid < r) ans = Math.max(query(node.rc, mid + 1, rr, l, r), ans);
        return ans;
    }


    private void pushDown(Node node) {
        if (node.add == 0) return;
        node.lc.data += node.add;
        node.lc.add += node.add;
        node.rc.data += node.add;
        node.rc.add += node.add;
        node.add = 0;
    }

    private void lazyCreate(Node node) {
        if (node.lc == null) node.lc = new Node();
        if (node.rc == null) node.rc = new Node();
    }

    private void pushUp(Node node) {
        node.data = Math.max(node.lc.data, node.rc.data);
    }
}