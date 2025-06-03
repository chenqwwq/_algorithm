//
// Created by chenqwwq on 2025/5/21.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minZeroArray(vector<int> &nums, vector<vector<int>> &queries) {
        auto n = nums.size(), m = queries.size();

        vector<int> diff(n + 1);
        // 等差数列恢复数组并检查
        auto check = [&](int x) -> bool {
            fill(diff.begin(), diff.end(), 0);

            for (int i = 0; i < x; i++) {
                int l = queries[i][0], r = queries[i][1], k = queries[i][2];
                diff[l] += k;
                diff[r + 1] -= k;
            }

            int t = 0;
            for (int i = 0; i < n; i++) {
                t += diff[i];
                if (t < nums[i]) return false;
            }
            return true;
        };

        int l = 0, r = m + 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (!check(mid)) l = mid + 1;
            else r = mid;
        }
        return l <= m ? l : -1;
    }
};