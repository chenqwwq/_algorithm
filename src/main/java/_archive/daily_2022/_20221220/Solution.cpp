//
// Created by chenqwwq on 2022/12/21.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumSize(vector<int> &nums, int maxOperations) {
        int l = 1, r = *max_element(nums.begin(), nums.end());
        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int cnt = getCnt(nums, mid);
            if (cnt > maxOperations) l = mid + 1;
            else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    int getCnt(vector<int> &nums, int k) {
        int ans = 0;
        for (int num: nums) ans += (num - 1) / k;
        return ans;
    }
};