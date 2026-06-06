//
// Created by 陈炳鑫 on 2022/2/26.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maximumDifference(vector<int> &nums) {
        int n = nums.size();
        int ans = -1, p = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[p])ans = max(ans, nums[i] - nums[p]);
            else p = i;
        }
        return ans;
    }
};