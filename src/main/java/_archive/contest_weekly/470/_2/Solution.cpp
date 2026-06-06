//
// Created by chenqwwq on 2025/10/8.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int longestSubsequence(vector<int> &nums) {
        if (all_of(nums.begin(), nums.end(), [](int a) { return a == 0; })) return 0;
        int x = 0;
        for (int num: nums) {
            x ^= num;
        }
        return x == 0 ? nums.size() - 1 : nums.size();
    }
};