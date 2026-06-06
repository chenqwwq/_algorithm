//
// Created by 陈炳鑫 on 2022/3/14.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        auto n = nums.size();
        sort(nums.begin(),nums.end());
        for (int i = 1; i < n; ++i) {
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }
};