//
// Created by chenqwwq on 2024/6/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
    int mod = 1e9 + 7;
public:
    int specialPerm(vector<int> &nums) {
        auto n = nums.size();
        unordered_map<int, vector<int>> map;
        for (auto num: nums) map[num] = {};
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] % nums[j] && nums[j] % nums[i]) continue;
                map[nums[i]].push_back(nums[j]);
                map[nums[j]].push_back(nums[i]);
            }
        }

    }
};