//
// Created by 陈炳鑫 on 2022/3/17.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxProfit(int k, vector<int> &nums) {
        int n = nums.size();
        vector<int> dp(k >> 1, 0);
        for (int i = 0; i < (k >> 1) - 1; i += 2) dp[k] = -nums[0];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < (k >> 1) - 1; j += 2) {
                dp[j] = max(dp[j], (j > 0 ? dp[j - 1] : 0) - nums[i]);
                dp[j + 1] = max(dp[j + 1], dp[j] + nums[i]);
            }
        }
        return dp[(k >> 1) - 1];
    }
};