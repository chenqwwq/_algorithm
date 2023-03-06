//
// Created by chenqwwq on 2023/1/16.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minMaxGame(vector<int> &nums) {
        if (nums.empty()) return -1;
        if (nums.size() == 1) return nums[0];
        int n = (int) nums.size() >> 1;
        vector<int> next(n);
        for (int i = 0; i < n; i++) {
            if (i & 1) next[i]= max(nums[i << 1],nums[(i << 1) + 1]);
            else next[i]= min(nums[i << 1],nums[(i << 1) + 1]);
        }
        return minMaxGame(next);
    }
};