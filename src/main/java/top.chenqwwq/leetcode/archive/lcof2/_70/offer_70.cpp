//
// Created by chenqwwq on 2022/1/10.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int singleNonDuplicate(vector<int> &nums) {
        int ans = 0;
        for (int &num: nums) ans ^= num;
        return ans;
    }
};