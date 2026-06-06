//
// Created by 陈炳鑫 on 2022/5/7.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, k, x;
    cin >> n >> k >> x;
    int nums[n];
    for (int i = 0; i < n; ++i) cin >> nums[i];

    if (x >= n) {
        long long ans = 0;
        for (int i = 0; i < n; ++i) ans += nums[i];
        printf("%lld\n", ans);
        return 0;
    }

    vector<vector<long long>> dp(n, vector<long long>(x + 1, 0));
    dp[0][1] = nums[0];
    for (int i = 1; i < n; ++i) {
        for (int j = 1; j <= x; ++j) {
            long long cur = -1;
            for (int l = 1; l <= k && i - l >= 0; ++l) {
                cur = max(max(dp[i - l][j], dp[i - l][j - 1] + nums[i]), cur);
            }
            dp[i][j] = cur;
        }
    }

    long long res = -1;
    for (int i = n - k; i <= n; ++i) res = max(res, dp[i][x]);
    printf("%lld\n", dp[n - 1][x]);
    return 0;
}