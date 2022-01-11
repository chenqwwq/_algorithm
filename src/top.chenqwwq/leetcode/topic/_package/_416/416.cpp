//
// Created by chen on 2021/6/8.
//

using namespace std;

#include "vector"
#include "memory.h"

class Solution {
public:
    bool canPartition(vector<int> &nums) {
        unsigned int n = nums.size();
        if (n < 2) {
            return false;
        }

        int sum = 0;
        for (auto num : nums) sum += num;
        if (sum & 1) {
            return false;
        }
        int target = sum >> 1;
        bool dp[target + 1];
        memset(dp, false, target + 1);
        dp[0] = true;

        // 大小为 target 的0,1背包问题
        for (int i = 0; i < n; ++i) {
            for (int j = target; j >= nums[i]; --j) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
};