//
// Created by chenqwwq on 2025/5/29.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> maxTargetNodes(vector<vector<int>> &edges1, vector<vector<int>> &edges2) {


        auto count = [](vector<vector<int>> &edges) {
            vector<vector<int>> g(edges.size() + 1);
            for (auto &e: edges) {
                g[e[0]].push_back(e[1]);
                g[e[1]].push_back(e[0]);
            }

            vector<int> cnt(2, 0);
            auto dfs = [&](auto self, int u, int fa, int d) -> void {
                cnt[d]++;
                for (auto v: g[u]) {
                    if (v == fa) continue;
                    self(self, v, u, d ^ 1);
                }
            };
            dfs(dfs, 0, -1, 0);
            return pair<vector<vector<int>>, vector<int>>(g, cnt);
        };


        auto [_, cnts] = count(edges2);
        int max2 = max(cnts[0], cnts[1]);

        auto [g, cnt1] = count(edges1);
        vector<int> ans(g.size(), max2);
        // 遍历更新整棵树
        auto dfs = [&](auto self, int u, int fa, int d) -> void {
            ans[u] += cnt1[d];
            for (auto nxt: g[u]) {
                if (nxt == fa) continue;
                self(self, nxt, u, d ^ 1);
            }
        };
        dfs(dfs, 0, -1, 0);
        return ans;
    }
};