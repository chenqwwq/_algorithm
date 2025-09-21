//
// Created by chenqwwq on 2025/5/25.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxProfit(int n, vector<int> &present, vector<int> &future, vector<vector<int>> &hierarchy, int budget) {
        // 1. 领导买不买
        // 2. 预算够不够
        vector<vector<int>> dp(budget, vector<int>(2, 0));
        int ans = 0;
        function<pair<int, int>(int)> dfs;
        dfs = [&](int u) -> pair<int, int> {


            for (auto v: hierarchy[u]) {
                auto [buy, notBy] = dfs(v);
            }
        };

        dfs(1);
        return ans;
    }
};