//
// Created by 陈炳鑫 on 2022/4/25.
//


#include <iostream>
#include <cstring>

using namespace std;

int main() {
    int N, M, L;
    cin >> N >> M;
    int order[M];
    for (int i = 0; i < M; ++i) cin >> order[i];
    cin >> L;
    int stripe[L];
    for (int i = 0; i < L; ++i) cin >> stripe[i];

    int dp[M];
    memset(dp, 0, sizeof(dp));
    for (int i = 0; i < L; ++i) {
        int mmax = 0;
        // 以当前节点作为末尾
        for (int j = 0; j < M; ++j) {
            mmax = max(mmax, dp[j]);
            if (stripe[i] == order[j]) {
                dp[j] = max(dp[j] + 1, mmax + 1);
                break;
            }
        }
    }
    int ans = 0;
    for (int i = 0; i < M; ++i) ans = max(ans, dp[i]);
    printf("%d\n", ans);
    return 0;
}