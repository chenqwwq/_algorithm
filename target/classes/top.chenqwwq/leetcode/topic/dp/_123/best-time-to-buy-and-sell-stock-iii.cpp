//
// Created by 陈炳鑫 on 2022/3/17.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &nums) {
        int n = nums.size();
        // 区分状态
        // 0 完成第一次买入
        // 1 第一次卖出
        // 2 第二次买入
        // 3 第二次卖出
        vector<vector<int>> dp(n, vector<int>(4, 0));

        dp[0][0] = -nums[0];
        dp[0][2] = -nums[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0] = max(-nums[i], dp[i - 1][0]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] - nums[i]);
            dp[i][3] = max(dp[i - 1][2] + nums[i], dp[i - 1][3]);
        }
        return dp[n - 1][3];
    }
};

int main() {
    vector<int> v1{7,6,4,3,1};
    (new Solution)->maxProfit(v1);
}