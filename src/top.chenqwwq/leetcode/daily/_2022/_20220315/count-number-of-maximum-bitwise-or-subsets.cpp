//
// Created by 陈炳鑫 on 2022/3/15.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:

    int countMaxOrSubsets(vector<int> &nums) {
        auto n = nums.size();
        int max = 0;
        for (int num: nums) max |= num;

        int ans = 0;
        for (int i = 1; i < 1 << n; ++i) {
            int tmp = 0;
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) tmp |= nums[j];
            }
            if (tmp == max) ans++;
        }
        return ans;
    }
//    int countMaxOrSubsets(vector<int> &nums) {
//        int n = nums.size();
//        int max = INT_MIN, cnt = 1;
//        std::function<void(int, int)> dfs;
//        dfs = [&](int i, int curr) {
//            if (i >= n) {
//                if (curr > max) {
//                    max = curr;
//                    cnt = 1;
//                } else if (curr == max) {
//                    cnt++;
//                }
//                return;
//            }
//            dfs(i + 1, curr);
//            dfs(i + 1, curr | nums[i]);
//        };
//
//        dfs(0, 0);
//        return cnt;
//    }
};