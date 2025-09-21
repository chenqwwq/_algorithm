//
// Created by chenqwwq on 2022/5/20.
//


#include <iostream>
#include "cstring"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int t;
    string data;
    cin >> t;
    // 每个字母的最后一个位置
    int maxn = 2e5 + 10;
    int h[26], dp[maxn];
    // 反向计算最大长度
    while (t--) {
        cin >> data;
        int n = (int) data.size();
        memset(h, 0x00, sizeof(h));
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];
            int &pos = h[data[i-1] - 'a'];
            if (pos) dp[i] = max(dp[i], dp[pos-1] + 2);
            pos = i;
        }
        printf("%d\n", n - dp[n]);
    }
    return 0;
}