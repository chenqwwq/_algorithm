//
// Created by chenqwwq on 2022/5/20.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int findLongestChain(vector<vector<int>> &pairs) {
        int n = (int) pairs.size();
        sort(pairs.begin(), pairs.end(), [](auto &a, auto &b) -> bool {
            return a[1] < b[1];
        });
        vector<int> dp(n, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            ans = max(ans,dp[i]);
        }
        return ans;
    }
};