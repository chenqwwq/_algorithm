//
// Created by chenqwwq on 2025/5/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    void sortColors(vector<int> &nums) {
        auto n = nums.size();
        int l = 0, r = n - 1;
        int cur = 0;
        while (cur <= r) {
            bool ad = true;
            if (nums[cur] == 0) {
                if (cur != l) {
                    ad = false;
                    swap(nums[cur], nums[l]);
                }
                l++;
            } else if (nums[cur] == 2) {
                swap(nums[cur], nums[r--]);
                ad = false;
            }
            if (ad)cur++;
        }
    }

//    void swap(vector<int> &nums, int i, int j) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }
};