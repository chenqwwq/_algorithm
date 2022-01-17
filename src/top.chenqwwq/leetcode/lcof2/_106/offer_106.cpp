//
// Created by chenqwwq on 2022/1/11.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> step;
    vector<bool> vis;

    // 二分图的判定,是否存在长度为奇数的环
    bool isBipartite(vector<vector<int>> &graph) {
        int n = graph.size();
        vis.resize(n);
        step.resize(n);
        for (int i = 0; i < n; ++i) {
            if (!vis[i] && !dfs(graph, i, 0)) return false;
        }

        return true;
    }

    bool dfs(vector<vector<int>> &graph, int i, int cs) {
        step[i] = cs;
        vis[i] = true;
        for (auto &v: graph[i]) {
            if (vis[v]) {
                if (((cs - step[v] + 1) & 1) == 1) return false;
            } else if (!dfs(graph, v, cs + 1)) return false;
        }
        return true;
    }

};

int main() {
    Solution *s = new Solution;
    vector<vector<int>> param{{1, 3},
                              {0, 2},
                              {1, 3},
                              {0, 2}};
    bool b = s->isBipartite(param);
    cout << b << endl;
}