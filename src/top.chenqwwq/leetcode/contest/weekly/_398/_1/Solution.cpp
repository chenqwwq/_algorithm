//
// Created by chenqwwq on 2024/5/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool isArraySpecial(vector<int> &nums) {
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (((nums[i] ^ nums[i + 1]) & 1) == 0) return false;
        }
        return true;
    }
};