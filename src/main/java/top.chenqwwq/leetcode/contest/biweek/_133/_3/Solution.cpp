//
// Created by chenqwwq on 2024/6/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minOperations(vector<int> &nums) {
        auto n = nums.size();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] + cur) & 1) continue;
            cur++;
        }
        return cur;
    }
};