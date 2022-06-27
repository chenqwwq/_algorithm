//
// Created by 陈炳鑫 on 2022/3/16.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int rob(vector<int> &nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        return max(robber(nums,0,n-2), robber(nums,1,n-1));
    }

    int robber(vector<int> &nums, int l, int r) {
        vector<int> dp(2, 0);
        dp[1] = nums[l];
        for (int i = l + 1; i <= r; ++i) {
            int t = max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = t;
        }
        return dp[1];
    }
};