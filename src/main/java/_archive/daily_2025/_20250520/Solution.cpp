//
// Created by chenqwwq on 2025/5/21.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool isZeroArray(vector<int> &nums, vector<vector<int>> &queries) {
        auto n = nums.size(), m = queries.size();

        vector<int> diff(n + 1, 0);
        for (int i = 0; i < m; i++) {
            auto q = queries[i];
            diff[q[0]] += 1;
            diff[q[1] + 1] -=1;
        }

        int t = 0;
        for (int i = 0; i < n; i++) {
            t += diff[i];
            if(t < nums[i]) return false;
        }
        return true;
    }
};
