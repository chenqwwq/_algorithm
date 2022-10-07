package template.binary_indexed_tree;

/**
 * @author chenqwwq
 * @date 2022/10/7
 **/
public class Fenwick {

    private final int[] tree;
    private final int cap;


    public Fenwick(int cap) {
        this.cap = cap;
        tree = new int[cap];
    }

    public Fenwick(int[] source) {
        this.cap = source.length;
        this.tree = new int[cap];
        System.arraycopy(source, 0, tree, 0, cap);

    }

    public void add(int p, int num) {
        for (; p < cap; p += lowbit(p)) {
            tree[p] += num;
        }
    }

    public long query(int p) {
        long ans = 0;
        for (; p > 0; p -= lowbit(p)) {
            ans += tree[p];
        }
        return ans;
    }

    private int lowbit(int x) {
        return x & -x;
    }

}
