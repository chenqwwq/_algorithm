package top.chenqwwq.leetcode.topic.segment_tree._307;

/**
 * @author chenqwwq
 * @date 2022/6/6
 **/
public class NumArray {
    private int[] seg;
    private int[] data;

    public NumArray(int[] nums) {
        data = nums;
        seg = new int[nums.length << 2];
        for (int i = 0; i < nums.length; i++) {
            update(1, 0, nums.length - 1, i, nums[i]);
        }
    }

    private void update(int u, int l, int r, int idx, int v) {
        if (l == r) {
            seg[u] = v;
            return;
        }
        int mid = l + (r - l >> 1);
        if (idx <= mid) {
            update(u << 1, l, mid, idx, v);
        } else {
            update(u << 1 | 1, mid + 1, r, idx, v);
        }
        seg[u] = seg[u << 1] + seg[u << 1 | 1];
    }

    public void update(int index, int val) {
        update(1, 0, data.length - 1, index, val);
    }

    private int query(int u, int l, int r, int ll, int rr) {
        if (ll <= l && rr >= r) {
            return seg[u];
        }
        int mid = l + (r - l >> 1);
        int ans = 0;
        if (ll <= mid) {
            ans += query(u << 1, l, mid, ll, rr);
        }
        if (rr > mid) {
            ans += query(u << 1 | 1, mid + 1, r, ll, rr);
        }
        return ans;
    }

    public int sumRange(int left, int right) {
        return query(1, 0, data.length - 1, left, right);
    }
}