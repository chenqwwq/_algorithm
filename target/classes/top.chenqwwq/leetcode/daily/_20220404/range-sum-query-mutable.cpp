//
// Created by 陈炳鑫 on 2022/4/4.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class NumArray {
private:
    vector<int> tree, src;
    int n;

    int lowbit(int i) {
        return i & -i;
    }

    void add(int i, int val) {
        while (i <= n) {
            tree[i] += val;
            i += lowbit(i);
        }
    }

    int sum(int i) {
        int ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= lowbit(i);
        }
        return ans;
    }

public:
    NumArray(vector<int> &nums) {
        src = nums;
        n = nums.size();
        tree.resize(n + 1);
        for (int i = 0; i < n; ++i) add(i + 1, nums[i]);
    }

    void update(int i, int val) {
        int diff = val - src[i];
        add(i + 1, diff);
        src[i] = val;
    }

    int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }
};

int main() {
    vector<int> v1{1, 3, 5};
    NumArray *pArray = new NumArray(v1);
    cout << pArray->sumRange(0, 2) << endl;
    pArray->update(1, 2);
    cout << pArray->sumRange(0, 2) << endl;
}
