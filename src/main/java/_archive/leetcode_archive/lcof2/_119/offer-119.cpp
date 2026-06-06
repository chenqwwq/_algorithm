//
// Created by chenqwwq on 2022/1/17.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int longestConsecutive(vector<int> &nums) {
        sort(nums.begin(),nums.end());
        unordered_map<int, int> hash;
        int ans = 0;
        for (auto num: nums) {
            auto len = (hash.find(num - 1) == hash.end() ? 0 : hash[num - 1]) + 1;
            hash[num] = len;
            ans = max(ans, len);
        }
        return ans;
    }
};