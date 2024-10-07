package top.chenqwwq.leetcode.daily._2024._20240728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/7/29
 **/
public class Solution {
    private static class SegmentTree_Dynamic {

        class Node {
            int ls, rs, add, max;
        }

        int N = (int) 1e9, M = 4 * 400 * 20, cnt = 1;
        SegmentTree_Dynamic.Node[] tr = new SegmentTree_Dynamic.Node[M];


        /**
         * 给l和r区间 +V
         */
        void add(int l, int r, int v) {
            add(1, 1, N + 1, l, r, v);
        }

        /**
         * 查询 l-r 区间的和
         */
        int query(int l, int r) {
            return query(1, 1, N + 1, l, r);
        }


        void add(int u, int lc, int rc, int l, int r, int v) {
            if (l <= lc && rc <= r) {
                tr[u].add += v;
                tr[u].max += v;
                return;
            }
            lazyCreate(u);
            pushdown(u);
            int mid = lc + rc >> 1;
            if (l <= mid) add(tr[u].ls, lc, mid, l, r, v);
            if (r > mid) add(tr[u].rs, mid + 1, rc, l, r, v);
            pushup(u);
        }

        int query(int u, int lc, int rc, int l, int r) {
            if (l <= lc && rc <= r) return tr[u].max;
            lazyCreate(u);
            pushdown(u);
            int mid = lc + rc >> 1, ans = 0;
            if (l <= mid) ans = Math.max(ans, query(tr[u].ls, lc, mid, l, r));
            if (r > mid) ans = Math.max(ans, query(tr[u].rs, mid + 1, rc, l, r));
            return ans;
        }

        void lazyCreate(int u) {
            if (tr[u] == null) tr[u] = new SegmentTree_Dynamic.Node();
            if (tr[u].ls == 0) {
                tr[u].ls = ++cnt;
                tr[tr[u].ls] = new SegmentTree_Dynamic.Node();
            }
            if (tr[u].rs == 0) {
                tr[u].rs = ++cnt;
                tr[tr[u].rs] = new SegmentTree_Dynamic.Node();
            }
        }

        void pushdown(int u) {
            tr[tr[u].ls].add += tr[u].add;
            tr[tr[u].rs].add += tr[u].add;
            tr[tr[u].ls].max += tr[u].add;
            tr[tr[u].rs].max += tr[u].add;
            tr[u].add = 0;
        }

        void pushup(int u) {
            tr[u].max = Math.max(tr[tr[u].ls].max, tr[tr[u].rs].max);
        }
    }


    public List<Integer> fallingSquares(int[][] positions) {
        SegmentTree_Dynamic tree = new SegmentTree_Dynamic();
        List<Integer> ans = new ArrayList<>(positions.length);
        int max = 0;
        for (int[] position : positions) {
            final int ll = position[0];
            final int rr = ll + position[1] - 1;
            max = Math.max(max,tree.query(ll, rr));
            ans.add(max);
            tree.add(ll, rr, position[1]);
        }
        return ans;
    }
}