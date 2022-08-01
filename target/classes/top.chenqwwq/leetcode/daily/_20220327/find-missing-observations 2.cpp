//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> missingRolls(vector<int> &rolls, int mean, int n) {
        auto m = rolls.size();
        int total = mean * (m + n), sum = 0;
        for (int num: rolls) sum += num;
        int need = total - sum;
        if (need < n || need > 6 * n) return {};

        vector<int> ans(n);
        // 分配 need 到 n 个数里面
        int base = need / n, rm = need % n;
        for (int i = 0; i < n; ++i) ans[i] = base + (i < rm ? 1 : 0);
        return ans;
    }
};