//
// Created by 陈炳鑫 on 2022/1/10.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:

    int minSwaps(vector<int> &nums) {
        int cnt = 0;
        for (int num: nums) {
            if (num == 1) cnt++;
        }
        nums.insert(nums.end(), nums.begin(), nums.end());
        int n = nums.size();
        int l = -1, r = -1, c0 = 0;
        int ans = cnt;
        while (++r < n) {
            if (nums[r] == 0) c0++;
            if (r >= cnt - 1) {
                ans = min(c0, ans);
                if (nums[++l] == 0) {
                    c0--;
                }
            }
        }
        return ans;
    }
};