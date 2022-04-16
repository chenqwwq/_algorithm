//
// Created by chenqwwq on 2022/1/13.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int dominantIndex(vector<int> &nums) {
        auto n = nums.size();
        if (n < 2) {
            return 0;
        }
        int max = INT_MIN, sec = INT_MIN;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                sec = max;
                max = nums[i];
                ans = i;
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
        }
        return max >> 1 >= sec ? ans : -1;
    }
};