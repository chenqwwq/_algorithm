//
// Created by 陈炳鑫 on 2022/4/22.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxRotateFunction(vector<int> &nums) {
        int sum = 0, n = nums.size();
        for (auto num: nums) sum += num;
        int pre = 0,ans = 0;
        for (int i = 0; i < n; ++i) pre += i * nums[i];
        // F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
        // F(1) = (1 * 4) + (2 * 3) + (3 * 2) + (0 * 6) = 0 + 4 + 6 + 6 = 16
        // F(2) = (2 * 4) + (3 * 3) + (0 * 2) + (1 * 6) = 0 + 6 + 8 + 9 = 23
        // [4,3,2,6]
        for (int i = 1; i < n; ++i){
            pre += sum - n * nums[n - i];
            ans = max(pre,ans);
        }
        return ans;
    }
};