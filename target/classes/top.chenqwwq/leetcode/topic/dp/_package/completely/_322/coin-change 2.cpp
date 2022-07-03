//
// Created by chen on 2022/2/17.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    const int INF = 0x3f3f3f3f;

    int coinChange(vector<int> &coins, int amount) {
        sort(coins.begin(), coins.end());
        vector<int> dp(amount + 1, INF);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (auto coin: coins) {
                if (coin <= i) dp[i] = min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
};