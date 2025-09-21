//
// Created by 陈炳鑫 on 2022/2/24.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> findBall(vector<vector<int>> &grid) {
        int n = grid[0].size();
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) ans[i] = handle(grid, 0, i);
        return ans;
    }

    int handle(vector<vector<int>> &grid, int i, int j) {
        if(i >= grid.size()) return j;
        bool ok = (grid[i][j] == 1 && (j + 1 >= grid[0].size() || grid[i][j + 1] == -1))
                  || (grid[i][j] == -1 && (j - 1 < 0 || grid[i][j - 1] == 1));
        if (ok) return -1;
        return handle(grid, i + 1, j + grid[i][j]);
    }
};