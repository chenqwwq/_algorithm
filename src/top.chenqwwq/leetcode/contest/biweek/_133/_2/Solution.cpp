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
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i]) continue;
            nums[i + 1] ^= 1;
            nums[i + 2] ^= 1;
            ans++;
        }
        return nums[n - 1] && nums[n - 2] ? ans : -1;
    }
};