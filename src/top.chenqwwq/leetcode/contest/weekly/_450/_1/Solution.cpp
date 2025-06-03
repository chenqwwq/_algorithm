//
// Created by chenqwwq on 2025/5/18.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int smallestIndex(vector<int> &nums) {
        auto n = nums.size();
        for (int i = 0; i < n; i++) {
            int cur = 0;
            while (nums[i]) {
                cur += nums[i] % 10;
                nums[i] /= 10;
            }
            if (cur == i) return i;
        }
        return -1;
    }
};