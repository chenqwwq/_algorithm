//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int minDeletion(vector<int> &nums) {
        auto n = nums.size();
        // 偶数
        int ans = 0;
        for (int i = 0; i + 1 < n;) {
            if (nums[i] != nums[i + 1]) {
                i += 2;
            } else {
                ans++;
                i++;
            }
        }
        if ((nums.size() & 1) != (ans & 1)) {
            ans++;
        }
        return ans;
    }
};