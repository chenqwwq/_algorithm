//
// Created by 陈炳鑫 on 2022/3/11.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxSubArray(vector<int> &nums) {
        int n = nums.size();
        // dp 表示当前下标的最大和
        int ans = INT_MIN, dp = 0;
        for (int i = 0; i < n; ++i) {
            dp = max(nums[i], dp + nums[i]);
            ans = max(ans, dp);
        }
        return ans;
    }
};