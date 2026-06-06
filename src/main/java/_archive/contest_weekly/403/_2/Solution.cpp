//
// Created by chenqwwq on 2024/6/23.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumArea(vector<vector<int>> &grid) {
        auto n = grid.size(), m = grid[0].size();
        int mxx = 0, mnx = m;
        int mxy = 0, mny = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    mxx = max(mxx, i);
                    mxy = max(mxy, j);
                    mnx = min(mnx, i);
                    mny = min(mny, j);
                }
            }
        }
        return (mxy - mny + 1) * (mxx - mnx + 1);
    }
};