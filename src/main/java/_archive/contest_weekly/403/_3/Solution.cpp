//
// Created by chenqwwq on 2024/6/23.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long maximumTotalCost(vector<int> &nums) {
        auto n = nums.size();
        vector<vector<long long>> dp(n, {0, 0}); // 0 为奇数，1 为偶数
        dp[0][0] = nums[0];
        dp[0][1] = -0x3f3f3f3f;
        for (int i = 1; i < n; i++) {
            dp[i][0] = max(dp[i - 1][0] + nums[i], dp[i - 1][1] + nums[i]);
            dp[i][1] = dp[i - 1][0] + -nums[i];
        }
        return max(dp[n - 1][0], dp[n - 1][1]);
    }
};