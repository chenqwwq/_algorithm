//
// Created by chenqwwq on 2022/5/16.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int wiggleMaxLength(vector<int> &nums) {
        int n = (int) nums.size();
        if (n == 1) return 1;
        if (n == 2) return nums[0] == nums[1] ? 1 : 2;
        int pu = 1, pd = 1;
        for (int i = 1; i < n; ++i) {
            int j = i - 1;
            if (nums[i] > nums[j]) pu = max(pu, pd + 1);
            else if (nums[i] < nums[j]) pd = max(pu + 1, pd);
        }
        return max(pu, pd);
    }
};