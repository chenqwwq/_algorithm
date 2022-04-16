//
// Created by 陈炳鑫 on 2022/3/20.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

typedef long long ll;

class Solution {
public:
    int networkBecomesIdle(vector<vector<int>> &edges, vector<int> &patience) {
        int n = patience.size();

        vector<vector<ll>> dis(n, vector<ll>(n, 0x3f3f3f3f));
        for (int i = 0; i < n; ++i) dis[i][i] = 0;

        for (auto edge: edges) {
            dis[edge[0]][edge[1]] = 1;
            dis[edge[1]][edge[0]] = 1;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    dis[j][k] = min(dis[j][k], dis[j][i] + dis[i][k]);
                }
            }
        }

        ll ans = 0;
        for (int i = 1; i < n; ++i) {
            ll rtt = dis[0][i] << 1, p = patience[i];
            ll lastPackageTime = rtt % p == 0 ? rtt - p : rtt - (rtt % patience[i]);
            ans = max(ans, lastPackageTime + rtt);
        }
        return (int)ans + 1;
    }
};

