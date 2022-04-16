//
// Created by chen on 2022/2/17.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxSubArray(vector<int> &nums) {
        // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        int n = nums.size();
        vector<int> dp(n);
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; ++i) ans = max(dp[i] = max(nums[i], nums[i] + dp[i - 1]), ans);
        return ans;
    }
};