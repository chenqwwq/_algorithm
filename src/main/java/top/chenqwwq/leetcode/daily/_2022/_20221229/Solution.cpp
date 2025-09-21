//
// Created by chenqwwq on 2022/12/29.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> twoOutOfThree(vector<int> &nums1, vector<int> &nums2, vector<int> &nums3) {
        int hash[101];
        ::memset(hash, 0, sizeof hash);
        for (auto num: nums1) hash[num] |= 1;
        for (auto num: nums2) hash[num] |= (1 << 1);
        for (auto num: nums3) hash[num] |= (1 << 2);

        vector<int> ans;
        for (int i = 1; i <= 100; i++) {
            if ((hash[i] & 1) + ((hash[i] >> 1) & 1) + ((hash[i] >> 2) & 1) > 1) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};