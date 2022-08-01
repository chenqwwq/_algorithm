//
// Created by chen on 2022/2/17.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<vector<int>> dp(2, vector<int>(rowIndex + 1));
        int flag = 0, curr = 0;
        while (curr <= rowIndex) {
            dp[flag][0] = 1;
            dp[flag][curr] = 1;
            for (int i = 1; i <= curr; ++i) dp[flag][i] = dp[flag ^ 1][i - 1] + dp[flag ^ 1][i];
            flag ^= 1;
            curr++;
        }
        return dp[flag ^ 1];
    }
};