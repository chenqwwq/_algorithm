//
// Created by chenqwwq on 2025/5/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>> &edges) {
        auto n = colors.size();

        // 构建图(邻接表
        vector<vector<int>> map(n, vector<int>());
        for (auto edge: edges) {
            // 自成环
            if (edge[0] == edge[1]) return -1;
            map[edge[0]].push_back(edge[1]);
        }

        // 缓存搜索状态
        vector<vector<int>> memo(n);
        function<vector<int>(int)> dfs;
        dfs = [&](int cur) -> vector<int> {
            if (!memo[cur].empty()) return memo[cur];
            vector<int> ret(26, 0);
            // 表示当前节点在搜索路径中
            memo[cur] = {0};
            for (auto next: map[cur]) {
                auto res = dfs(next);
                // 大小等于1表示有环
                if (res.size() <= 1) return res;
                // 取每个颜色的最大值
                for (int i = 0; i < 26; i++) {
                    ret[i] = max(ret[i], res[i]);
                }
            }
            ret[colors[cur] - 'a']++;
            return memo[cur] = ret;
        };

        int ans = 0;
        for (int i = 0; i < n; i++) {
            auto ret = dfs(i);
            if (ret.size() <= 1) return -1;
            for (auto cnt: ret) {
                ans = max(ans, cnt);
            }
        }
        return ans;
    }
};