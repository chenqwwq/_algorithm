//
// Created by 陈炳鑫 on 2022/3/15.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int findPeakElement(vector<int> &nums) {
        auto n = nums.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (mid + 1 >= n || nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
};