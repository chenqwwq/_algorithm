//
// Created by 陈炳鑫 on 2022/3/16.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int rob(vector<int> &nums) {
        vector<int> dp(2, 0);
        dp[1] = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            int t = max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = t;
        }
        return dp[1];
    }
};