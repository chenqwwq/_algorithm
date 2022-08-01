//
// Created by chen on 2022/2/17.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    int cx[8]{-2, -1, 1, 2, 2, 1, -1, -2}, cy[8]{1, 2, 2, 1, -1, -2, -2, -1};

    int getMask(int x, int y, int n) {
        return x * n + y;
    }

    unordered_map<int, unordered_map<int, double>> memo;
public:
    double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1;
        int mask = getMask(row, column, n);
        if (memo[mask].find(k) != memo[mask].end()) return memo[mask][k];

        double tmp = 0;
        for (int i = 0; i < 8; ++i) {
            int x = row + cx[i], y = column + cy[i];
            if (x < 0 || y < 0 || x >= n || y >= n) continue;
            tmp += knightProbability(n, k - 1, x, y) * 0.125;
        }

        memo[mask][k] = tmp;
        return tmp;
    }
};