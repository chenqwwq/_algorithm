package top.chenqwwq.leetcode.topic.segment_tree._327;

import template.segment_tree.DynamicSegmentTree;

/**
 * @author chenqwwq
 * @date 2025/1/4
 **/
public class Solution2 {

    public long min(long... nums) {
        long min = Long.MAX_VALUE;
        for (long num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    public long max(long... nums) {
        long max = Long.MIN_VALUE;
        for (long num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        // 前缀和套线段树
        // i->j 的区间满足要求: lower <= ps[i] - ps[j] <= upper
        // 从前往后遍历前缀和,短数据 ps[j] 的 范围在 {ps[i] - lower,ps[i] - upper] 的满足要求
        final int n = nums.length;

        // 求前缀和
        final long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = nums[i] + ps[i];
        }

        // 求值域
        long ll = Long.MAX_VALUE, rr = Long.MIN_VALUE;
        for (long p : ps) {
            ll = min(ll, p, p - lower, p - upper);
            rr = max(rr, p, p - lower, p - upper);
        }

        // 遍历并构造线段树
        final DynamicSegmentTree tree = new DynamicSegmentTree(ll, rr);

        int ans = 0;
        for (long p : ps) {
            ans += tree.query(p - upper, p - lower);
            tree.update(p, p, 1);
        }
        return ans;

    }

    private static final class Node {
        long ll, rr;
        Node lc, rc; // 左右子节点
        int add = 0, data = 0; // 懒标记和真实数据

        public Node(long ll, long rr) {
            this.ll = ll;
            this.rr = rr;
        }
    }

    public static class DynamicSegmentTree {

        public static final int N = (int) 1e9 + 7;
        private final Node root;

        public DynamicSegmentTree() {
            this.root = new Node(0, N);
        }

        public DynamicSegmentTree(long ll, long rr) {
            this.root = new Node(ll, rr);
        }


        // 区间更新
        // 单点更新就是 l,r 相同

        public void update(long l, long r, int v) {
            update(root, l, r, v);
        }


        /**
         * ll,rr 表示 node 的值域
         * l,r 表示更新的区间
         * v 表示更新的值
         */
        private void update(Node node, long l, long r, int v) {
            // l <= ll <= rr < r
            if (l <= node.ll && node.rr <= r) {
                node.data += v;
                node.add += v;
                return;
            }

            // 懒创建
            // 中间值
            long mid = node.ll + ((node.rr - node.ll) >> 1);

            // 下推
            pushDown(node, mid);


            // 分段更新
            if (l <= mid) {
                if (node.lc == null) node.lc = new Node(node.ll, mid);
                update(node.lc, l, r, v);
            }
            if (r > mid) {
                if (node.rc == null) node.rc = new Node(mid + 1, node.rr);
                update(node.rc, l, r, v);
            }

            // 更新当前值
            pushUp(node);
        }

        // 区间查询

        public int query(long l, long r) {
            return query(root, l, r);
        }

        private int query(Node node, long l, long r) {
            if (node == null) return 0;
            if (l > node.rr || r < node.ll) return 0;
            if (l <= node.ll && r >= node.rr) return node.data;
            long mid = node.ll + ((node.rr - node.ll) >> 1);
            pushDown(node, mid);
            return query(node.lc, l, r) + query(node.rc, l, r);
        }


        private void pushDown(Node node, long mid) {
            if (node.add == 0) return;
            if (node.lc == null) node.lc = new Node(node.ll, mid);
            node.lc.data += node.add;
            node.lc.add += node.add;
            if (node.rc == null) node.rc = new Node(mid + 1, node.rr);
            node.rc.data += node.add;
            node.rc.add += node.add;
            node.add = 0;
        }


        private void pushUp(Node node) {
            node.data = (node.lc != null ? node.lc.data : 0) + (node.rc != null? node.rc.data :0);
        }
    }
}
