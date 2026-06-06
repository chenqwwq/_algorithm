//
// Created by chen on 2021/6/7.
//
using namespace std;

#include "vector"
#include "memory.h"

class Solution {
public:
    int findTargetSumWays(vector<int> &nums, int target) {
        int sum = 0;
        for (auto num : nums) sum += num;
        int dp[sum >> 1];
        memset(dp, 0, sum >> 1)
        std::cout << sum << std::endl;
        for (auto num : nums){
            std::cout << num << std::endl;
        }

    };
private:
};