//
// Created by chenqwwq on 2023/3/31.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;
typedef long long ll;


class Solution {
public:
    int arithmeticTriplets(vector<int> &nums, int diff) {
        int n = (int) nums.size();
        bool exist[201];
        ::memset(exist, false, sizeof(exist));
        for (auto num: nums) {
            exist[num] = true;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int b = a + diff,c = b + diff;
            if(b < 201 && c < 201 && exist[b] && exist[c]) ans++;
        }
        return ans;
    }
};