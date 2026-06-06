//
// Created by chen on 2022/2/17.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    int cx[8]{-2, -1, 1, 2, 2, 1, -1, -2}, cy[8]{1, 2, 2, 1, -1, -2, -2, -1};

public:
    double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1;
        vector<vector<vector<double>>> memo(n, vector<vector<double>>(n, vector<double>(k + 1)));
        for (int i = 0; i < n ; ++i) {
            for (int j = 0; j < n; ++j) {
                memo[i][j][0] = 1;
            }
        }
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int l = 0; l < n; ++l) {
                    for (int m = 0; m < 8; ++m) {
                        int x = i + cx[m], y = cy[m];
                        if(x < 0 || y < 0 || x >= n || y >= n) continue;
                        memo[j][l][i] += memo[x][y][i-1] / 8;
                    }
                }
            }
        }
        return memo[row][column][k];
    }
};