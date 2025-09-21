//
// Created by chenqwwq on 2022/8/30.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    typedef long long ll;
    int N = 1001;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, q;
    int h1, w1, h2, w2;
    cin >> t;
    // 二维前缀和
    while (t--) {
        cin >> n >> q;
        vector<vector<ll>> sum(N, vector<ll>(N, 0l));
        for (int i = 0; i < n; ++i) {
            cin >> h1 >> w1;
            sum[h1][w1] += h1 * w1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            cin >> h1 >> w1 >> h2 >> w2;
            cout << (sum[h2 - 1][w2 - 1] - sum[h1][w2 - 1] - sum[h2 - 1][w1] + sum[h1][w1]) << endl;
        }
    }
    return 0;
}