package top.chenqwwq.leetcode.daily._20220606;

import template.tree.DyCreateSegmentTree;

import java.util.function.BiFunction;

/**
 * @author chenqwwq
 * @date 2022/6/6
 **/
public class MyCalendarThree {

    public static final int MAXN = (int) 1e9;

    public class DyCreateSegmentTree {
        class Node {
            // 左右子节点
            Node lc, rc;

            // 左右边界
            int l, r;

            // 懒标记和真实数据
            int add, data;

            public Node(int l, int r) {
                this.l = l;
                this.r = r;
            }

            public int mid() {
                return l + ((r - l) >> 1);
            }
        }


        private final Node root;
        private final BiFunction<Integer, Integer, Integer> merger;

        public DyCreateSegmentTree(int l, int r, BiFunction<Integer, Integer, Integer> merger) {
            this.root = new Node(l, r);
            this.merger = merger;
        }

        public DyCreateSegmentTree(BiFunction<Integer, Integer, Integer> merger) {
            this.root = new Node(0, MAXN);
            this.merger = merger;
        }

        // 区间更新

        public void update(int l, int r, int v) {
            update(root, l, r, v);
        }

        private void update(Node node, int l, int r, int v) {
            if (l <= node.l && node.r <= r) {
                node.add += v;
                node.data += v;
                return;
            }
            lazyCreate(node);
            pushDown(node);
            int mid = node.mid();
            if (l <= mid) {
                update(node.lc, l, r, v);
            }
            if (mid < r) {
                update(node.rc, l, r, v);
            }
            pushUp(node);
        }

        // 区间查询

        public int query(int l, int r) {
            return query(root, l, r);
        }

        private int query(Node node, int l, int r) {
            if (l <= node.l && r >= node.r) {
                return node.data;
            }
            pushDown(node);
            int mid = node.mid();
            int ans = 0;
            if (l <= mid) {
                ans = query(node.lc, l, r);
            }
            if (mid < r) {
                ans = Math.max(query(node.rc, l, r), ans);
            }
            return ans;
        }


        private void lazyCreate(Node node) {
            if (node.lc == null) {
                node.lc = new Node(node.l, node.l + ((node.r - node.l) >> 1));
            }
            if (node.rc == null) {
                node.rc = new Node((node.l + ((node.r - node.l) >> 1)) + 1, node.r);
            }
        }

        private void pushDown(Node node) {
            if (node == null || node.add == 0) {
                return;
            }

            node.lc.data += node.add;
            node.lc.add += node.add;
            node.rc.data += node.add;
            node.rc.add += node.add;
            node.add = 0;
        }

        private void pushUp(Node node) {
            node.data = merger.apply(node.lc.data, node.rc.data);
        }
    }

    DyCreateSegmentTree tree;

    public MyCalendarThree() {
        this.tree = new DyCreateSegmentTree(Math::max);
    }

    public int book(int start, int end) {
        tree.update(start, end - 1, 1);
        return tree.query(0, MAXN);
    }
}