//
// Created by 陈炳鑫 on 2022/4/16.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int perfectMenu(vector<int> &materials, vector<vector<int>> &cookbooks, vector<vector<int>> &attribute, int limit) {
        int n = (int) cookbooks.size();
        auto check = [&](int i, vector<int> &ms) -> bool {
            for (int j = 0; j < 5; ++j) {
                if (ms[j] < cookbooks[i][j]) return false;
            }
            return true;
        };

        int ans = -1;
        function<void(int i, vector<int> &ms, int x, int y)> dfs;
        dfs = [&](int i, vector<int> &ms, int x, int y) {
            if (i >= n) {
                if (y >= limit) ans = max(ans, x);
                return;
            }
            dfs(i + 1, ms, x, y);
            if (!check(i, ms)) return;
            for (int j = 0; j < 5; ++j) ms[j] -= cookbooks[i][j];
            dfs(i + 1, ms, x + attribute[i][0], y + attribute[i][1]);
            for (int j = 0; j < 5; ++j) ms[j] += cookbooks[i][j];
        };
        dfs(0, materials, 0, 0);
        return ans;
    }
};