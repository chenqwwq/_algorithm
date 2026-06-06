//
// Created by 陈炳鑫 on 2022/3/16.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;


class Solution {
public:

    int longest(vector<int> &nums) {
        int n = nums.size();
        int ans = 0, mmax = INT_MIN;
        int r = -1;
        for (int l = 0; l < n; l++) {
            if (nums[l] == 0) continue;
            if (r == -1) r = mmax = l;
            else {
                // 找到l之后第一个等于1的位置
                int len = (l - r) >> 1;
                if (len > mmax) {
                    ans = r + ((l - r + 1) >> 1);
                    mmax = len;
                }
                // r = n _1
                r = l;
            }
        }
        // l 是右边最后一个1
        if (r != -1 || r != n - 1) {
            if (n - r > mmax) ans = n - 1;
        }

        return ans;
    }

};

int main() {
    vector<int> v1{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
    (new Solution)->longest(v1);
}