//
// Created by 陈炳鑫 on 2022/2/20.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    long long coutPairs(vector<int>& nums, int k) {
        int n = nums.size();
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if(nums[i] % k != 0) continue;
            ans++;
        }
        return ans * (n - ans) + (ans * (ans-1)) / 2;
    }
};