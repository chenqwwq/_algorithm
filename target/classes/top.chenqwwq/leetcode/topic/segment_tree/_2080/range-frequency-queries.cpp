//
// Created by chenqwwq on 2022/6/2.
//


#include "stdc++.h"
#include "common.h"

using namespace std;


class RangeFreqQuery {
public:
    vector<map<int, int>> tree;
    int n;

    RangeFreqQuery(vector<int> &arr) {
        n = (int) arr.size();
        tree.resize(n << 2);
        for (int i = 0; i < n; i++) {
            update(1, 0, n - 1, i, arr[i]);
        }
    }

    void update(int p, int l, int r, int idx, int v) {
        if (l == r) {
            tree[p][v]++;
            return;
        }

        int mid = (l + r) >> 1, ll = p << 1, rr = p << 1 | 1;
        if (idx <= mid) {
            update(ll, l, mid, idx, v);
        } else {
            update(rr, mid + 1, r, idx, v);
        }
        tree[p][v]++;
    }

    int query(int p, int l, int r, int ll, int rr, int val) {
        if (l == ll && r == rr) {
            return tree[p][val];
        }
        int mid = (l + r) >> 1, lc = p << 1, rc = p << 1 | 1;
        if (ll > mid) {
            return query(rc, mid + 1, r, ll, rr, val);
        } else if (rr <= mid) {
            return query(lc, l, mid, ll, rr, val);
        }
        return query(rc, mid + 1, r, mid + 1, rr, val) + query(lc, l, mid, ll, mid, val);
    }

    int query(int left, int right, int value) {
        return query(1, 0, n - 1, left, right, value);
    }
};