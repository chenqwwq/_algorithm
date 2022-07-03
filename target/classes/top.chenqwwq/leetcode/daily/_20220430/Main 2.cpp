//
// Created by 陈炳鑫 on 2022/4/30.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int smallestRangeI(vector<int> &nums, int k) {
        return max((int)(*max_element(nums.begin(), nums.end()).base() - *min_element(nums.begin(), nums.end()).base() - 2 * k), 0);
    }
};