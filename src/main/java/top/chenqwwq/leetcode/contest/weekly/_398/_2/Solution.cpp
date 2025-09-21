//
// Created by chenqwwq on 2024/5/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<bool> isArraySpecial(vector<int> &ns, vector<vector<int>> &qs) {
        auto n = ns.size(), m = qs.size();
        int vis[n];
        memset(vis, 0, sizeof(vis));
        for (int i = 0; i < n - 1; i++) {
            vis[i + 1] = (1 - (ns[i] ^ ns[i + 1]) & 1) + vis[i];
        }
        vector<bool> ans(m);
        for (int i = 0; i < m; i++) {
            ans[i] = !(vis[qs[i][1]] - vis[qs[i][0]]);
        }
        return ans;
    }
};