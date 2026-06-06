//
// Created by 陈炳鑫 on 2022/3/16.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &nums) {
        int n = nums.size();
        // dp[0] 表示股票持有状态,dp[1] 表示不持有状态
        vector<int> dp(2, 0);

        // 初始值
        dp[0] = -nums[0];

        // 从第一天开始推
        for (int i = 1; i < n; ++i) {
            // 持有股票的状态 = （前一天就持有 ，前一天不持有当天买入）
            int d1 = max(dp[0], dp[1] - nums[i]);
            // 不持有股票的状态 = （前一天持有今天卖掉，前一天就不持有）
            int d2 = max(nums[i] + dp[0], dp[1]);
            dp[0] = d1;dp[1] = d2;
        }
        return dp[1];;
    }
};
