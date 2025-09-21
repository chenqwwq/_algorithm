package top.chenqwwq.leetcode.topic.segment_tree._327;

import org.junit.platform.commons.util.AnnotationUtils;

import java.util.function.BiFunction;

/**
 * @author chenqwwq
 * @date 2025/1/4
 **/
public class Solution {


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
        final Node root = new Node(ll, rr);

        int ans = 0;
        for (long p : ps) {
            ans += cnt(root, p - upper, p - lower);
            insert(root, p);
        }
        return ans;

    }

    //  线段树的单点写入
    public void insert(Node node, long idx) {
        node.cnt++;
        if (node.ll == node.rr) return;
        long mid = (node.ll + node.rr) >> 1;
        if (idx <= mid) {
            if (node.l == null) node.l = new Node(node.ll, mid);
            insert(node.l, idx);
        } else {
            if (node.r == null) node.r = new Node(mid + 1, node.rr);
            insert(node.r, idx);
        }
    }


    public int cnt(Node node, long l, long r) {
        if (node == null) return 0;
        if (l > node.rr || r < node.ll) return 0;
        if (l <= node.ll && node.rr >= r) return node.cnt;
        return cnt(node.l, l, r) + cnt(node.r, l, r);
    }


    static class Node {
        long ll, rr;
        int cnt = 0;
        Node l, r;

        public Node(long ll, long rr) {
            this.ll = ll;
            this.rr = rr;
        }
    }

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
}