//
// Created by chenqwwq on 2025/4/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maximumPossibleSize(vector<int> &nums) {
        auto n = nums.size();
        int ans = 1, cur = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= cur) {
                ans++;
                cur = nums[i];
            }
        }
        return ans;
    }
};