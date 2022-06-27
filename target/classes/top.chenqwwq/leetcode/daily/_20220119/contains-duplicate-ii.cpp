//
// Created by chenqwwq on 2022/1/19.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool containsNearbyDuplicate(vector<int> &nums, int k) {
        auto n = nums.size();
        unordered_set<int> _set;
        for (int i = 0; i < n; ++i) {
            if (i > k) {
                _set.erase(nums[i - k - 1]);
            }
            if (_set.find(nums[i]) != _set.end()) {
                return true;
            }
            _set.insert(nums[i]);
        }
        return false;
    }
};