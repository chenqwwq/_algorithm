package basis.tree.seg;

import java.util.function.BiFunction;

/**
 * @author chenqwwq
 * @date 2022/5/26
 **/
public class SegmentTree {
    private final int[] data;
    private int[] tree;
    private boolean[] lazy;
    private final int cap;
    private final BiFunction<Integer, Integer, Integer> merger;

    public SegmentTree(int[] source, BiFunction<Integer, Integer, Integer> merger) {
        this.cap = source.length;
        this.data = new int[cap];
        this.lazy = new boolean[cap];
        System.arraycopy(source, 0, data, 0, cap);
        this.merger = merger;
        // 直接构建
        build(0, 0, cap - 1);
    }

    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

    public void build(int idx, int l, int r) {
        if (l == r) {
            tree[idx] = data[l];
            return;
        }
        int left = leftChild(idx), right = rightChild(idx), mid = (l + r) >> 1;
        build(left, l, mid);
        build(right, mid + 1, r);
        tree[idx] = merger.apply(tree[l], tree[r]);
    }

    /**
     * 区间查询
     */
    public int query(int l, int r) {
        if (l < 0 || r >= cap || r < 0 || l >= cap || l > r) {
            return 0;
        }
        return query(0, 0, cap - 1, l, r);
    }

    public int query(int pos, int l, int r, int ll, int rr) {
        if (l == ll && r == rr) {
            return tree[pos];
        }
        int left = leftChild(pos), right = rightChild(pos), mid = (l + r) >> 1;
        if (rr < mid) {
            // 在区间的左边
            return query(left, l, mid, ll, rr);
        }
        if (ll > mid) {
            return query(right, mid + 1, r, ll, rr);
        }
        return merger.apply(query(left, l, mid, ll, rr), query(right, mid + 1, r, ll, rr));
    }
}
