//
// Created by chenqwwq on 2024/7/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>> &grid) {
        auto n = grid.size(), m = grid[0].size();
        vector<int> rs(n, 0), cs(m, 0);     // 行列和
        vector<int> rm(n, 0), cm(m, 0);     // 行列最大值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rm[i] = max(rm[i], grid[i][j]);
                cm[j] = max(cm[j], grid[i][j]);
                rs[i] += grid[i][j];
                cs[j] += grid[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += rm[i] * m - rs[i]
        }
    }
};