//
// Created by 陈炳鑫 on 2022/3/15.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int search(vector<int> &nums, int target) {
        auto n = nums.size();
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
        }
        return -1;
    }
};