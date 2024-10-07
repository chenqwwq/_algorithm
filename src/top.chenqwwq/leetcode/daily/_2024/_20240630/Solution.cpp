//
// Created by chenqwwq on 2024/6/30.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:

    int ans = 0;

    int findTargetSumWays(vector<int> &nums, int target) {
        dfs(0, target, nums);
        return ans;
    }


    void dfs(int i, int target, vector<int> &nums) {
        if (i >= nums.size()) {
            if (!target) ans++;
            return;
        }
        dfs(i + 1, target - nums[i], nums);
        dfs(i + 1, target + nums[i], nums);
    }
};