//
// Created by 陈炳鑫 on 2022/4/28.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> sortArrayByParity(vector<int> &nums) {
        vector<int> even, odd;
        for (auto num: nums) {
            if (num & 1) odd.push_back(num);
            else even.push_back(num);
        }
        even.insert(even.end(),odd.begin(),odd.end());
        return even;
    }
};