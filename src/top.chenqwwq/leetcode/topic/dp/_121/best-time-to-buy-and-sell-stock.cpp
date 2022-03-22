//
// Created by 陈炳鑫 on 2022/3/16.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &nums) {
        int n = nums.size();
        int mmin = nums[0], ans = 0;
        for (int i = 1; i < n; ++i) {
            if(nums[i] < mmin) mmin = nums[i];
            else if(nums[i] > mmin) ans = max(ans,nums[i] - mmin);
        }
        return ans;
    }
};