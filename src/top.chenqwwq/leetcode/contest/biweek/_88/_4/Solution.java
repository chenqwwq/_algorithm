package top.chenqwwq.leetcode.contest.biweek._88._4;

/**
 * @author chenqwwq
 * @date 2022/10/7
 **/
public class Solution {

    class Fenwick {

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

    int M = (int) 1e5;
    int N = (int) 1e6 + 10;

    Fenwick fenwick;

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        // 化简原公式 ==> (nums1[i] - nums2[i]) - (nums1[j] - nums2[j]) <= diff
        int n = nums1.length;
        fenwick = new Fenwick(N);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = nums1[i] - nums2[i] + 40000;
            ans += fenwick.query(tmp + diff);
            fenwick.add( tmp,1);
        }
        return ans;
    }
}