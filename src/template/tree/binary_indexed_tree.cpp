//
// Created by 陈炳鑫 on 2022/4/4.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

/**
 * 树状数组
 */
class BinaryIndexedTree {
private:
    vector<int> tree;
    int n;

    int lowbit(int i) {
        return i & -i;
    }

public:
    BinaryIndexedTree(vector<int> &ds) {
        n = (int) ds.size();
        tree.resize(n + 1);
        for (int i = 0; i < n; ++i) add(i + 1, ds[i]);
    }

    /**
     * 单点新增
     */
    void add(int i, int val) {
        while (i <= n) {
            tree[i] += val;
            i += lowbit(i);
        }
    }

    /**
     * 前缀和
     */
    int pre_sum(int i) {
        int ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= lowbit(i);
        }
        return ans;
    }
};