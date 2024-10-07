//
// Created by chenqwwq on 2024/6/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long maximumTotalDamage(vector<int> &power) {
        unordered_map<int, int> cnt;
        for (auto p: power)cnt[p] += p;

        vector<pair<int, int>> vec(cnt.begin(), cnt.end());
        sort(vec.begin(), vec.end(), less<pair<int, int>>());

        auto n = vec.size();
        int dp[n][2];
        dp[0][1] = vec[0].second;
        for (int i = 1; i < n; i++) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
            
        }
    }
};