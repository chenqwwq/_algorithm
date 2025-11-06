//
// Created by chenqwwq on 2025/9/30.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int triangularSum(vector<int> &nums) {
        if (nums.size() == 1) return nums[0];
        vector<int> next(nums.size() - 1);
        for (int i = 0; i < nums.size() - 1; ++i) {
            next[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return triangularSum(next);
    }
};