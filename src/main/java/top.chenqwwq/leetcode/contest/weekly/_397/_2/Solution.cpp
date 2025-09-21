//
// Created by chenqwwq on 2024/5/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maximumEnergy(vector<int> &energy, int k) {
        int n = energy.size();
        int dp[n], ans = 0;
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            if (i < k)dp[i] = energy[i];
            else dp[i] = max(dp[i - k] + energy[i], energy[i]);
            if(i > n - k)ans = max(ans,dp[i]);
        }
        return ans;
    }
};