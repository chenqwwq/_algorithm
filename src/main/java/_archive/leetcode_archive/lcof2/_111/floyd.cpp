//
// Created by chenqwwq on 2022/1/16.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    // 拓扑排序失败，开始 floyd
    vector<double>
    calcEquation(vector<vector<string>> &equations, vector<double> &values, vector<vector<string>> &queries) {
        // 直接对整张图进行预处理,查询的时候可以直接查询结果
        // 对每个字符串进行离散化处理
        unordered_map<string, int> _map;
        int cnt = 0;
        auto n = equations.size();
        for (int i = 0; i < n; ++i) {
            auto data = equations[i];
            if (_map.find(data[0]) == _map.end()) {
                _map[data[0]] = cnt++;
            }
            if (_map.find(data[1]) == _map.end()) {
                _map[data[1]] = cnt++;
            }
        }

        // 构造全图,使用邻接矩阵
        vector<vector<double>> graph(cnt, vector<double>(cnt, -1.0));
        for (int i = 0; i < n; ++i) {
            auto eq = equations[i];
            int p1 = _map[eq[0]], p2 = _map[eq[1]];
            graph[p1][p2] = values[i];
            graph[p2][p1] = 1 / values[i];
        }

        for (int i = 0; i < cnt; ++i) {
            for (int j = 0; j < cnt; ++j) {
                for (int k = 0; k < cnt; ++k) {
                    if (graph[j][i] > 0 && graph[i][k] > 0) {
                        graph[j][k] = graph[j][i] * graph[i][k];
                    }
                }
            }
        }

        auto m = queries.size();
        vector<double> ans(m, -1.0);
        for (int i = 0; i < m; ++i) {
            auto ps = queries[i];
            if (_map.find(ps[0]) == _map.end() || _map.find(ps[1]) == _map.end()) {
                continue;
            }
            ans[i] = graph[_map[ps[0]]][_map[ps[1]]];
        }
        return ans;
    }
};

int main() {
    vector<vector<string>> p1{{"a", "b"},
                              {"b", "c"}};

    vector<double> p2{2.0, 3.0};
    vector<vector<string>> p3{{"a", "c"},
                              {"b", "a"},
                              {"a", "e"},
                              {"a", "a"},
                              {"x", "x"}};

    Solution *pSolution = new Solution;
    pSolution->calcEquation(p1, p2, p3);
}