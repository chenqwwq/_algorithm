//
// Created by chenqwwq on 2025/5/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool canPartitionGrid(vector<vector<int>> &grid) {
        // 二维前缀和
        auto n = grid.size(), m = grid[0].size();

        vector<vector<long>> sum(n, vector<long>(m, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] = grid[i][j];
                if (i > 0) sum[i][j] += sum[i - 1][j];
                if (j > 0) sum[i][j] += sum[i][j - 1];
                if (i > 0 && j > 0) sum[i][j] -= sum[i - 1][j - 1];
            }
        }
        if((sum[n-1][m-1] & 1) == 1) return false;
        long half = sum[n-1][m-1] >> 1;
        for (int i = 0; i < n; i++) {
            if (sum[i][m-1] == half) return true;
        }
        for (int i = 0; i < m; i++) {
            if (sum[n-1][i] == half) return true;
        }
        return false;
    }
};