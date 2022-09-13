package template.segment_tree;

import java.util.function.BiFunction;

/**
 * 非动态开点的线段树实现
 *
 * @author chenqwwq
 * @date 2022/5/26
 **/
public class SegmentTree {
    // 原始数据
    private final int[] data;
    // 线段树数据
    private int[] tree;
    // 线段树容量，通常为 data 的4倍
    private final int cap;
    /**
     * pushup
     */
    private final BiFunction<Integer, Integer, Integer> merger;

    /**
     * 针对 source（原数组） 创建线段树
     */
    public SegmentTree(int[] source, BiFunction<Integer, Integer, Integer> merger) {
        this.cap = source.length;
        this.tree = new int[cap << 2];
        this.data = new int[cap];
        this.lazy = new int[cap];
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

    /**
     * 在 idx 赋值 l 和 r 的数据
     */
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

    // 区间查询


    public int query(int l, int r) {
        if (l < 0 || r >= cap || r < 0 || l >= cap || l > r) {
            return 0;
        }
        return query(0, 0, cap - 1, l, r);
    }

    public int query(int pos, int l, int r, int ll, int rr) {
        if (l >= ll && r <= rr) return tree[pos];
        int left = leftChild(pos), right = rightChild(pos), mid = (l + r) >> 1;
        // 在区间的左边
        if (rr < mid) return query(left, l, mid, ll, rr);
        if (ll > mid) return query(right, mid + 1, r, ll, rr);
        return merger.apply(query(left, l, mid, ll, rr), query(right, mid + 1, r, ll, rr));
    }

    // 单点更新
    // 单点更新通过（中层）递归找到需要修改的点，后续通过 merge 将修改传递到上层

    public void update(int idx, int val) {
        if (idx < 0 || idx >= data.length) return;
        data[idx] = val;
        update(0, 0, cap - 1, idx, val);
    }

    public void update(int u, int l, int r, int idx, int v) {
        if (r < idx || l > idx) return;
        if (l == r) {
            tree[l] = v;
            return;
        }
        int left = leftChild(u), right = rightChild(u), mid = (l + r) >> 1;
        if (idx > mid) update(right, mid + 1, r, idx, v);
        else update(left, l, mid, idx, v);
        tree[u] = merger.apply(tree[left], tree[right]);
    }

    // 区间修改 + 懒标记 + 对应的懒查询
    // 区间修改是将（l，r）的值全部变成 val 或者增减一定的数值

    public void update(int l, int r, int val) {
        for (int i = l; i <= r; i++) {
            update(i, val);
        }
    }

    // 懒标记 lazy-Tag,记录还没有作用于子节点的修改
    private int[] lazy;

    public void lazyUpdate(int l, int r, int v) {
        lazyUpdate(0, 0, cap - 1, l, r, v);
    }

    /**
     * u 表示当前节点
     * l,r 分别表示当前的左右边界
     * ll,rr 分别表示更新区间的左右边界
     * v 表示操作数，加法为正，减法为负
     * <p>
     * TODO: 未验证
     */
    private void lazyUpdate(int u, int l, int r, int ll, int rr, int v) {
        //  被完全包含的情况:
        // --- | --- | --- | --- | ---
        //     ll    l     r     rr
        if (ll <= l && r <= rr) {
            if (l == r) {
                data[u] += v;
            }
            tree[u] += (r - l + 1) * v;
            lazy[u] += v;
            return;
        }
        pushDown(u, l, r);

        // l ~ mid 中包含部分需要更新的元素
        int mid = (l + r) >> 1;
        if (ll <= mid) lazyUpdate(u << 1, l, mid, ll, rr, v);
        if (mid < r) lazyUpdate(u << 1 | 1, mid + 1, r, ll, rr, v);
        pushUp(u);
    }

    public int lazyQuery(int u, int l, int r, int ll, int rr) {
        if (l >= ll && r <= rr) {
            return tree[u];
        }
        pushDown(u, l, r);

        int mid = (l + r) >> 1;
        int ans = 0;
        if (ll <= mid) ans += lazyQuery(u, l, mid, ll, rr);
        if (mid < rr) ans += lazyQuery(u, mid + 1, r, ll, rr);
        return ans;
    }

    private void pushUp(int u) {
        data[u] = merger.apply(data[u << 1], data[u << 1 | 1]);
    }

    /**
     * ln和rn 分别表示左子树的个数和右子树的个数
     * <p>
     */
    private void pushDown(int u, int l, int r) {
        if (lazy[u] <= 0) return;
        lazy[u << 1] += lazy[u];
        lazy[u << 1 | 1] += lazy[u];

        final int mid = l + (r - l) >> 1;
        tree[u << 1] += lazy[u] * (mid - l + 1);
        tree[u << 1 | 1] += lazy[u] * (r - mid);

        lazy[u] = 0;
    }
}
