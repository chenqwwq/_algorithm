//
// Created by chen on 2022/2/17.
//
#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int numWays(int n, vector<vector<int>> &relation, int k) {
        // dp[i][j] -> 0经过i步传递到j的方案数
        vector<vector<int>> dp(k + 1, vector<int>(n));
        dp[0][0] = 1;
        for (int i = 1; i <= k; ++i) {
            for (auto vec: relation) {
                int x = vec[0], y = vec[1];
                dp[i][y] += dp[i - 1][x];
            }
        }
        return dp[k][n - 1];
    }
};