//
// Created by chenqwwq on 2025/9/28.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int largestPerimeter(vector<int> &nums) {
        if (size(nums) < 3) {
            return 0;
        }
        const auto n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
};