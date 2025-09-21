//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    const int INF = 0x3f3f3f3f;

    int coinChange(vector<int> &v, int amount) {
        sort(v.begin(), v.end());
        auto n = v.size();
        // dp[i] 表示i块钱的硬币个数
        // dp[i] = 1-j...min(dp[i],dp[i-j * v[i]] + j)
        vector<int> dp(amount + 1, INF);
        dp[0] = 0;
        // 多少钱
        for (int i = 0; i <= amount; ++i) {
            // 前i+1种硬币
            for (int j = 0; j < n; ++j) {
                // 使用多少当前种硬币
                if (v[j] > i) continue;
                dp[i] = min(dp[i], dp[i - v[j]] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
};

