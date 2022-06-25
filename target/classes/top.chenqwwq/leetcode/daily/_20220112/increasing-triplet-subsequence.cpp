//
// Created by chenqwwq on 2022/1/12.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool increasingTriplet(vector<int> &nums) {
        auto n = nums.size();
        if (n < 3) {
            return false;
        }

        auto x = INT_MAX, y = INT_MAX;
        for (auto num: nums) {
            if (num <= x) {
                x = num;
            } else if (num <= y) {
                y = num;
            } else {
                return true;
            }
        }
        return false;
    }
};