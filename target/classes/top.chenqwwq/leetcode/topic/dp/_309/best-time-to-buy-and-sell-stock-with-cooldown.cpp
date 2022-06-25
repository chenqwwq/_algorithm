//
// Created by 陈炳鑫 on 2022/3/17.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &nums) {
        int n = nums.size();
        // dp[i][0] 表示持有股票的情况
        // dp[i][1] 表示当天卖出的情况，后一天只能冷却
        // dp[i][2] 表示不持有的情况
        vector<vector<int>> dp(n, vector<int>(3, 0));
        dp[0][0] = -nums[0];
        for (int i = 1; i < n; ++i) {
            // 持有股票的情况 = 前一天就持有股票，前一天冷却今天买入
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - nums[i]);
            // 当天卖出的情况
            dp[i][1] = nums[i] + dp[i - 1][0];
            // 不持有股票但是在冷却期
            dp[i][2] = max(dp[i - 1][1], dp[i - 1][2]);
        }
        return max(dp[n - 1][1], dp[n - 1][2]);
    }
};