package top.chenqwwq.leetcode.contest.weekly._440._3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2025/3/9
 **/
public class Solution {


    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.n = fruits.length;

        tree = new int[n << 2];

        Integer[] ns = new Integer[n];
        for (int i = 0; i < n; i++) ns[i] = i;
        Arrays.sort(ns, Comparator.comparingInt(o -> baskets[o]));
        return -1;
    }

    int N = (int) (1e5 + 1);
    private int[] tree;
    int n;

    public void update(int pos, int val) {
        update(0, 0, n - 1, pos, val);
    }

    private void update(int cur, int l, int r, int idx, int val) {
        if (l == r) {
            tree[cur] = val;
            return;
        }
        int mid = l + (r - l >> 1);
        int ll = (cur << 1) + 1, rr = (cur << 1) + 2;
        if (idx <= mid) {
            update(ll, l, mid, idx, val);
        } else {
            update(rr, mid + 1, r, idx, val);
        }
        tree[cur] = Math.max(tree[ll], tree[rr]);
    }

    public int queryMax(int l, int r) {
        return queryTree(0, 0, n - 1, l, r);
    }

    private int queryTree(int treeIndex, int start, int end, int l, int r) {
        if (r < start || end < l) return Integer.MIN_VALUE; // 无交集
        if (l <= start && end <= r) return tree[treeIndex]; // 完全包含
        int mid = start + (end - start) / 2;
        int leftMax = queryTree(2 * treeIndex + 1, start, mid, l, r);
        int rightMax = queryTree(2 * treeIndex + 2, mid + 1, end, l, r);
        return Math.max(leftMax, rightMax);
    }

}