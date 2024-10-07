//
// Created by chenqwwq on 2024/8/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;
const int N = 1010;
int n, v,m, w;
int dp[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> v;
    for (int i = 0; i < n; ++i) {
        cin >> m >> w;
        for (int j = v; j >= m; j--) {
            dp[j] = max(dp[j], dp[j - m] + w);
        }
    }
    cout << dp[v] << endl;
    return 0;
}