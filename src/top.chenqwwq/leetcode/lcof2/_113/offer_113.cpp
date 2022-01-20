//
// Created by chenqwwq on 2022/1/14.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites) {
        // 拓扑排序 就是 DAG 所有顶点的线性排序
        // 无环就能保证全部学完
        vector<int>indegree(numCourses);
        vector<vector<int>> graph(numCourses);
        for (auto pre: prerequisites) {
            graph[pre[1]].push_back(pre[0]);
            indegree[pre[0]]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; ++i) {
            if (!indegree[i]) {
                q.push(i);
            }
        }

        vector<int> ans;
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            ans.push_back(i);
            for (int next: graph[i]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.push(next);
                } else if (indegree[next] < 0) {
                    return {};
                }
            }
        }
        if (ans.size() < numCourses) ans.clear();
        return ans;
    }
};