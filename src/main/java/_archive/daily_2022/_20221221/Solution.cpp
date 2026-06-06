//
// Created by chenqwwq on 2022/12/21.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maximumScore(int a, int b, int c) {
        vector<int> nums{a, b, c};
        sort(nums.begin(), nums.end());
        int ans = 0;
        while (nums[0] + nums[1] > nums[2]) {
            ans++;
            nums[0]--;
            nums[1]--;
        }
        return ans + min(nums[0]+nums[1],nums[2]);
    }
};