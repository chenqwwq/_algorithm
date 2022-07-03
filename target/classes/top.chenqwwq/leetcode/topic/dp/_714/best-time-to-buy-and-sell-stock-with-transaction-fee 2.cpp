//
// Created by 陈炳鑫 on 2022/3/17.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &nums, int fee) {
        int n = nums.size();
        // dp[i][0] 表示持有股票,dp[i][1] 表示不持有
        vector<vector<int>> dp(n, vector<int>(2, 0));

        // 初始
        dp[0][0] = -fee - nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - nums[i] - fee);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
            cout << dp[i][0] << ":" << dp[i][1] << endl;
        }

        return dp[n - 1][1];
    }
};