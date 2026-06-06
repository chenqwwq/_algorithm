//
// Created by chenqwwq on 2025/5/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long maximumValueSum(vector<int> &nums, int k, vector<vector<int>> &edges) {
        // 树形 DP
        auto n = nums.size();

        // 构建树
        unordered_map<int, vector<int>> tree;
        for (auto edge: edges) {
            if (tree.find(edge[0]) == tree.end())tree[edge[0]] = {};
            tree[edge[0]].emplace_back(edge[1]);
            if (tree.find(edge[1]) == tree.end()) tree[edge[1]] = {};
            tree[edge[1]].emplace_back(edge[0]);
        }


        // 函数返回包含子树根节点的偶数次变换、奇数次变换的最大值
        function<pair<ll, ll>(int, int)> dfs;
        dfs = [&](int cur, int p) -> pair<ll, ll> {
            // 偶数次和奇数次
            ll l = 0, r = LLONG_MIN;
            for (auto next: tree[cur]) {
                if (next == p) continue;
                auto [l1, r1] = dfs(next, cur);
                ll t = max(r + l1, r1 + l);
                l = max(l + l1, r + r1);
                r = t;
            }
            return {max(l + nums[cur], r + (nums[cur] ^ k)), max(r + nums[cur], l + (nums[cur] ^ k))};
        };

        return dfs(0, -1).first;
    };
};