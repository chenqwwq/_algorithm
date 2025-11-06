//
// Created by chenqwwq on 2025/10/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int longestSubarray(vector<int> &nums) {
        auto n = nums.size();
        if (n <= 2) return n;

        int ans = 2;
        for (int l = 0, r = 2; r < n;) {
            while (r < n && nums[r - 2] + nums[r - 1] == nums[r]) {
                r++;
            }

            ans = max(ans, r - l);
            l = r++ - 1;
        }
        return ans;
    }
};