package top.chenqwwq.leetcode.daily._20220719;

import java.util.Objects;

/**
 * @author 沽酒
 * @since 2022/07/19
 */
public class MyCalendarTwo {

    class Node {
        Node lc, rc;
        int add;
        int max;
    }

    private static final int N = (int) 1e9 + 7;
    private final Node root;

    private void update(Node node, int l, int r, int ll, int rr, int val) {
        if (l >= ll && r <= rr) {
            node.max += val;
            node.add += val;
            return;
        }
        pushdown(node);
        int mid = l + r >> 1;
        if (ll <= mid) update(node.lc, l, mid, ll, rr, val);
        if (rr > mid) update(node.rc, mid + 1, r, ll, rr, val);
        liftup(node);
    }

    private int query(Node node, int l, int r, int ll, int rr) {
        if (l >= ll && r <= rr){
            return node.max;
        }
        pushdown(node);
        int mid = l + r >> 1,lv = 0, rv = 0;
        if (ll <= mid) lv = query(node.lc, l, mid, ll, rr);
        if (rr > mid) rv = query(node.rc, mid+1, r, ll, rr);
        return Math.max(lv, rv);
    }

    private void pushdown(Node node) {
        if (Objects.isNull(node.lc)) node.lc = new Node();
        if (Objects.isNull(node.rc)) node.rc = new Node();
        if (node.add == 0) return;
        int v = node.add;
        node.lc.add += v;node.lc.max += v;
        node.rc.add += v;node.rc.max += v;
        node.add = 0;
    }

    private void liftup(Node node) {
        node.max = Math.max(node.lc.max, node.rc.max);
    }

    public MyCalendarTwo() {
        root = new Node();
    }

    public boolean book(int start, int end) {
        if (query(root, 0, N, start, end - 1) >= 2) return false;
        update(root, 0, N, start, end - 1, 1);
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10,20);
        myCalendarTwo.book(50,60);
    }
}