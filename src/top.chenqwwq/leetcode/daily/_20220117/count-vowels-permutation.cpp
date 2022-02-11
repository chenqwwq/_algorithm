//
// Created by chenqwwq on 2022/1/17.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

typedef long long LL;

class Solution {

private:
    long long MOD = 1e9 + 7;
public:
    int countVowelPermutation(int n) {
        if (n == 1) {
            return 5;
        }
        // 分别保存 a e i o u
        vector<LL> dp(5, 1),tmp;
        for (int i = 2; i <= n; ++i) {
            tmp[0] = (dp[4] + dp[1] + dp[2]) % MOD;
            tmp[1] = (dp[0] + dp[2]) % MOD;
            tmp[2] = (dp[1] + dp[3]) % MOD;
            tmp[3] = dp[2];
            tmp[4] = (dp[2] + dp[3]) % MOD;
            dp = tmp;
        }
        return (int)accumulate(dp.begin(), dp.end(), 0LL) % MOD;
    }
};