//
// Created by 陈炳鑫 on 2022/3/21.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> main(vector<int> &nums) {
        auto n = nums.size();

        vector<int> dp(n, 0);
        dp[0] = nums[0];
        int mmax = dp[0], l = 0, r = 0;
        int al = 0, ar = 0;
        for (int i = 1; i < n; ++i) {
            // dp[i] 表示i为最后一个元素的最大子集和
            // dp[i] = max(nums[i] + dp[i - 1], nums[i]);
            int a = nums[i] + dp[i - 1];
//            dp[i] = max(nums[i] + dp[i - 1], nums[i]);
            if (a > nums[i]) {
                dp[i] = a;
                r = i;
            } else {
                dp[i] = nums[i];
                r = i;
                l = i;
            }
            if (dp[i] > mmax) {
                mmax = dp[i];
                al = l;
                ar = r;
            }
        }

        return {al, ar};
    }
};