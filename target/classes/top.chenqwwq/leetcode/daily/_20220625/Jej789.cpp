//
// Created by chenqwwq on 2022/6/25.
//


#include "bits/stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;

class Solution {
public:
    int minCost(vector<vector<int>> &cs) {
        int n = (int) cs.size();
        int dp[n][3];
        dp[0][0] = cs[0][0];
        dp[0][1] = cs[0][1];
        dp[0][2] = cs[0][2];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + cs[i][0];
            dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + cs[i][1];
            dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + cs[i][2];
        }
        return *min_element(dp[n - 1], dp[n - 1] + 3);
    }
};