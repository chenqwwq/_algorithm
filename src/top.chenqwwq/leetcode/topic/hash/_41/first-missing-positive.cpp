//
// Created by 陈炳鑫 on 2022/3/26.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int firstMissingPositive(vector<int> &nums) {
        // 原地 Hash
        auto n = nums.size();
        for (int i = 0; i < n; ++i) {
            // 可以置换
            while (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums[i], nums[nums[i] - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
};