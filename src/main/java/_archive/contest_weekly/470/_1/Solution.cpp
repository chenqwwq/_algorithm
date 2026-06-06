//
// Created by chenqwwq on 2025/10/8.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int alternatingSum(vector<int> &nums) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            ans += (i % 2 == 0 ? 1 : -1) * nums[i];
        }
        return ans;
    }
};