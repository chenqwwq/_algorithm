//
// Created by chenqwwq on 2025/5/29.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> maxTargetNodes(vector<vector<int>> &edges1, vector<vector<int>> &edges2, int k) {
        size_t n = edges1.size() + 1, m = edges2.size() + 1;
        vector<vector<int>> g1(n), g2(m);
        for (auto &e: edges1) {
            g1[e[0]].push_back(e[1]);
            g1[e[1]].push_back(e[0]);
        }
        for (auto &e: edges2) {
            g2[e[0]].push_back(e[1]);
            g2[e[1]].push_back(e[0]);
        }

        // (根节点,父节点,最大长度) -> 小于最大长度的个数
        function<int(vector<vector<int>>, int, int, int len)> dfs;
        dfs = [&](vector<vector<int>> g, int u, int fa, int len) -> int {
            if (len < 0) return 0;
            int res = 1;
            for (int v: g[u]) {
                if (v == fa) continue;
                res += dfs(g, v, u, len - 1);
            }
            return res;
        };

        // 找出第二棵树最大为 k-1 的路径节点数
        int m2 = 0;
        for (int i = 0; i < m; i++) {
            m2 = max(m2, dfs(g2, i, -1, k - 1));
        }

        vector<int> ans(n, 0);
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(g1, i, -1, k) + m2;
        }
        return ans;
    }
};
