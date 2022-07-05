package top.chenqwwq.leetcode.daily._20220705;

import template.tree.DyCreateSegmentTree;

import java.util.function.BiFunction;

/**
 * @author 沽酒
 * @since 2022/07/05
 */
public class MyCalendar {
    DyCreateSegmentTree root;

    public MyCalendar() {
        root = new DyCreateSegmentTree(Integer::sum);
    }

    public boolean book(int start, int end) {
        int query = root.query(start, end - 1);
        if (query > 0) {
            return false;
        }
        root.update(start, end - 1, 1);
        return true;
    }

    static class DyCreateSegmentTree {
        /**
         * 动态节点，不记录左右边界值
         */
        class Node {
            Node lc, rc; // 左右子节点
            int add, data; // 懒标记和真实数据
        }

        public static final int MAXN = (int) 1e9 + 7;
        private final Node root;
        private final BiFunction<Integer, Integer, Integer> merger;

        public DyCreateSegmentTree(BiFunction<Integer, Integer, Integer> merger) {
            this.root = new Node();
            this.merger = merger;
        }

        // 区间更新

        public void update(int l, int r, int v) {
            update(root, 0, MAXN, l, r, v);
        }

        private void update(Node node, int ll, int rr, int l, int r, int v) {
            if (l <= ll && rr <= r) {
                node.data += (rr - ll + 1) * v;
                node.add += v;
                return;
            }
            int mid = ll + ((rr - ll) >> 1);
            pushDown(node, mid - ll + 1, rr - mid);
            if (l <= mid) update(node.lc, ll, mid, l, r, v);
            if (r > mid) update(node.rc, mid + 1, rr, l, r, v);
            pushUp(node);
        }

        // 区间查询

        public int query(int l, int r) {
            return query(root, 0, MAXN, l, r);
        }

        private int query(Node node, int ll, int rr, int l, int r) {
            if (l <= ll && r >= rr) {
                return node.data;
            }
            int mid = ll + ((rr - ll) >> 1);
            pushDown(node, mid - ll + 1, rr - mid);
            int ans = 0;
            if (l <= mid) {
                ans = query(node.lc, ll, mid, l, r);
            }
            if (mid < r) {
                ans = Math.max(query(node.rc, mid + 1, rr, l, r), ans);
            }
            return ans;
        }


        private void lazyCreate(Node node) {
            if (node.lc == null) node.lc = new Node();
            if (node.rc == null) node.rc = new Node();
        }

        private void pushDown(Node node, int lc, int rc) {
            lazyCreate(node);
            if (node.add == 0) return;
            node.lc.data += lc * node.add;
            node.lc.add += node.add;
            node.rc.data += rc * node.add;
            node.rc.add += node.add;
            node.add = 0;
        }

        private void pushUp(Node node) {
            node.data = merger.apply(node.lc.data, node.rc.data);
        }
    }
}