//
// Created by chenqwwq on 2024/6/23.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    double minimumAverage(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        double ans = 0x3f3f3f3f;
        auto n = nums.size();
        for (int i = 0; i < n >> 1; i++) {
            ans = min(ans, (double) (nums[i] + nums[n - i - 1]) / (double) 2);
        }
        return ans;
    }
};