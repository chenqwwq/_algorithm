//
// Created by 陈炳鑫 on 2022/3/10.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

//class Solution {
//private:
//    int MOD = 1000000007;
//public:
//    int numRollsToTarget(int n, int k, int target) {
//        if (n * k < target) return 0;
//        vector<vector<int>> dp(n + 1, vector<int>(target + 1, 0));
//        dp[0][0] = 1;
//        for (int i = 1; i <= n; ++i) {
//            for (int j = i; j <= min(i * k,target); ++j) {
//                for (int l = 1; l <= k && j >= l; ++l) {
//                    dp[i][j] = (dp[i][j] + dp[i-1][j-l]) % MOD;
//                }
//            }
//        }
//        return dp[n][target];
//    }
//};

class Solution {
private:
    int MOD = 1000000007;
public:
    int numRollsToTarget(int n, int k, int target) {
        if (n * k < target) return 0;
        vector<vector<int>> dp(2, vector<int>(target + 1, 0));
        dp[0][0] = 1;
        int flag = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= min(i * k, target); ++j) {
                for (int l = 1; l <= k && j >= l; ++l) {
                    dp[flag][j] = (dp[flag][j] + dp[flag ^ 1][j - l]) % MOD;
                }
            }
            flag ^= 1;
        }
        return dp[flag ^ 1][target];
    }
};