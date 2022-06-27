//
// Created by chenqwwq on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

// 拓扑排序解法

class Solution {
public:
    bool sequenceReconstruction(vector<int> &org, vector<vector<int>> &seqs) {
        auto n = org.size();
        vector<int> indegree(n);
        unordered_set<int> set;
        vector<unordered_set<int>> graph(n);

        // 构造图
        for (auto val: seqs) {
            auto m = val.size();
            for (int i = 0; i < m ; ++i) {
                int p1 = val[i] - 1;
                set.insert(p1);
                if (val[i] <= 0 || val[i] > org.size() || val[i] == val[i + 1]) {
                    return false;
                }
                int p2 = val[i + 1] - 1;;
                set.insert(p2);
                if (!graph[p1].count(p2)) {
                    indegree[p2]++;
                    graph[p1].insert(p2);
                }
            }
        }
        if (set.size() != n) {
            return false;
        }

        // 拓扑排序
        vector<int> path;
        queue<int> q;
        vector<bool> vis(n);
        // 入度为0的节点入队列
        for (int i = 0; i < n; ++i) {
            if (0 == indegree[i]) {
                q.push(i);
                vis[i] = true;
            }
        }
        while (!q.empty()) {
            if (q.size() != 1) {
                return false;
            }
            auto top = q.front();
            path.push_back(top);
            q.pop();
            for (auto val: graph[top]) {
                indegree[val]--;
                if (indegree[val] == 0 && !vis[val]) {
                    vis[val] = true;
                    q.push(val);
                }
            }
        }

        if (path.size() != n) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (org[i] - 1 != path[i]) {
                return false;
            }
        }
        return true;
    }
};

int main() {
    Solution *pSolution = new Solution;
    vector<int> p1{1};
    vector<vector<int>> p2{{1},
                           {1},
                           {1}};
    pSolution->sequenceReconstruction(p1, p2);
}

