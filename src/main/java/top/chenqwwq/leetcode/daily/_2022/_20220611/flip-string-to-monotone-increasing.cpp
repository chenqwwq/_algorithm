//
// Created by chenqwwq on 2022/6/11.
//


#include "bits/stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;

class Solution {
public:
    int minFlipsMonoIncr(string s) {
        int n = (int) s.length();
        int dp[2]{s[0] - '0', '1' - s[0]};
        for (int i = 1; i < n; ++i) {
            dp[1] = min(dp[1], dp[0]) + '1' - s[i];
            dp[0] = dp[0] + s[i] - '0';
        }
        return min(dp[0], dp[1]);
    }
};