//
// Created by 陈炳鑫 on 2022/3/4.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    long long subArrayRanges(vector<int> &nums) {
        // 1 2 3 5 6 4
        // 1 2,1 3,1 5,1 6,1 6,
        // 2 3,2 5,2 6,2 6
        // 3 5,3 6,3 6
        // [1,2]，范围 = 2 - 1 = 1
        // [2,3]，范围 = 3 - 2 = 1
        // [1,2,3]，范围 = 3 - 1 = 2

        int n = nums.size();
        vector<int> mmax(n, nums[0]);
        long long ans = 0;
        for (int i = n; i > 0; --i) {
            int mmin = INT_MAX,mmax = INT_MIN;
            for (int j = i - 1; j >= 0; --j) {
                mmin = min(mmin, nums[j]);
                mmax = max(mmax,nums[j]);
                ans += mmax - mmin;
            }
        }
        return ans;
    }
};

int main() {
    vector<int> p1{1, 2, 3};
    cout << (new Solution)->subArrayRanges(p1);
}