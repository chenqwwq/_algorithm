//
// Created by chenqwwq on 2022/5/21.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxn = 1e4+1;
    int repeatedNTimes(vector<int> &nums) {
        bool h[maxn];
        memset(h, 0x00, sizeof(h));
        for (int i = 0; i < nums.size(); ++i) {
            if(h[nums[i]]){
                return nums[i];
            }
            h[nums[i]] = true;
        }
        return -1;
    }
};