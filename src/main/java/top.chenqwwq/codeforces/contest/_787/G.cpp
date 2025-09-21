//
// Created by 陈炳鑫 on 2022/5/7.
//

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    int ds[n + 1];
    ds[0] = 0;
    for (int i = 1; i <= n; ++i) cin >> ds[i], ds[i] += ds[i - 1];
    // dp 表示的是前n个数,一共m个元素 达到非递增的移动数
    int dp[n + 1][m + 1];
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
            dp[i][j] = 0;
        }
    }

    // i个元素
    for (int i = m; i >= 0; --i) {
        // j个桶
        for (int j = 1; j <= n; ++j) {
            // 当前一共几个
            for (int k = i; k <= m; ++k) {
                // ab、
                dp[j][k] = min(dp[j][k], dp[j - 1][k - i] + abs(k - ds[j]));
            }
        }
    }
    printf("%d\n", dp[n][m]);
    return 0;
}

