package top.chenqwwq.leetcode.contest.weekly._310._4;

/**
 * @author chenqwwq
 * @date 2022/9/11
 **/
public class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int maxn = (int) (1e5 + 10);
        final int n = nums.length;
        build(1, 1, maxn);
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            update(1, num, num);
        }
        int ans = 0;
        while ((min = query(1, min, min + k)) != 0) {
            ans++;
        }
        return ans;
    }

    class Node {
        int l, r, val;

        Node(int _l, int _r) {
            l = _l;
            r = _r;
            val = Integer.MIN_VALUE;
        }
    }

    Node[] tr = new Node[100010 * 4];

    void build(int u, int l, int r) {
        tr[u] = new Node(l, r);
        if (l == r) return;
        int mid = l + r >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }

    void update(int u, int x, int v) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].val = Math.min(tr[u].val, v);
            return;
        }
        int mid = tr[u].l + tr[u].r >> 1;
        if (x <= mid) update(u << 1, x, v);
        else update(u << 1 | 1, x, v);
        pushup(u);
    }

    int query(int u, int l, int r) {
        if (l <= tr[u].l && tr[u].r <= r) return tr[u].val;
        int mid = tr[u].l + tr[u].r >> 1, ans = Integer.MIN_VALUE;
        if (l <= mid) ans = query(u << 1, l, r);
        if (r > mid) ans = Math.min(ans, query(u << 1 | 1, l, r));
        return ans;
    }

    void pushup(int u) {
        tr[u].val = Math.min(tr[u << 1].val, tr[u << 1 | 1].val);
    }
}
