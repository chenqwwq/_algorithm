//
// Created by chenqwwq on 2022/8/1.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    typedef long long ll;

    const int mod = 998244353;
    int n, m, k;
    cin >> n >> m >> k;
    vector<vector<ll>> dp(n, vector<ll>(k + 1, 0));
    dp[0][0] = m;
    for (int i = 1; i < n; i++) {
        dp[i][0] = m;
        for (int j = 1; j <= k; j++) {
            // 相同和不同区别计算
            dp[i][j] = (dp[i - 1][j - 1] * (m - 1) + dp[i - 1][j]) % mod;
        }
    }

    cout << dp[n - 1][k] << endl;
    return 0;
}