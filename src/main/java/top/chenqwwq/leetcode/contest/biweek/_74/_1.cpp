//
// Created by 陈炳鑫 on 2022/3/19.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool divideArray(vector<int> &nums) {
        int n = nums.size();
        unordered_map<int, int> hash;
        for (int num: nums)hash[num]++;

        for (auto [k,v] : hash){
            if((v & 1) == 1) return false;
        }
        return true;
    }
};