//
// Created by 陈炳鑫 on 2022/3/11.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxSubarraySumCircular(vector<int> &nums) {
        int n = nums.size();
        int dmax = 0, dmin = 0, sum = 0, mmin = 0x3f3f3f3f, mmax = -0x3f3f3f3f;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            dmax = max(nums[i], dmax + nums[i]);
            dmin = min(nums[i], dmin + nums[i]);
            mmin = min(dmin, mmin);
            mmax = max(dmax, mmax);
        }

        cout << mmax << ":" << sum - mmin;
        return mmin == sum ? mmax : max(mmax, sum - mmin);
    }
};

int main() {
    // 1 -1 2 0
    vector<int> v1{-3, -2, -3};
    (new Solution)->maxSubarraySumCircular(v1);
}