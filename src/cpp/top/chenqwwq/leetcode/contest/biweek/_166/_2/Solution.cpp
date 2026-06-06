//
// Created by chenqwwq on 2025/9/28.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    const int INF = 0x3f3f3f3f;

    int climbStairs(int n, vector<int> &costs) {
        vector<int> dp(n + 1, INF);
        dp[0] = 0;
        for (int i = 0; i < n + 1; ++i) {
            for (int j = 1; j < 4 && i + j < n + 1; ++j) {
                dp[i + j] = min(dp[i + j], dp[i] + costs[i + j - 1] + j * j);
            }
        }

        return dp[n - 1];
    }
};