//
// Created by 陈炳鑫 on 2022/3/6.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>> &edges) {
        int m = edges.size();
        vector<unordered_set<int>> tmp(n, unordered_set<int>{});
        unordered_map<int, vector<int>> graph;
        vector<int> indegree(n, 0);
        for (int i = 0; i < m; ++i) {
            auto edge = edges[i];
            indegree[edge[1]]++;
            if (graph.find(edge[0]) == graph.end()) graph[edge[0]] = vector<int>{};
            graph[edge[0]].push_back(edge[1]);
        }

        queue<int> qq;
        for (int i = 0; i < n; i++) if (!indegree[i]) qq.push(i);

        while (!qq.empty()) {
            int curr = qq.front();
            qq.pop();
            for (int num: graph[curr]) {
                tmp[num].insert(curr);
                tmp[num].insert(tmp[curr].begin(), tmp[curr].end());
                if (!--indegree[num]) qq.push(num);
            }
        }

        vector<vector<int>> ans(n);
        for (int i = 0; i < n; ++i) {
            vector<int> v;
            v.assign(tmp[i].begin(),tmp[i].end());
            sort(v.begin(), v.end());
            ans[i] = v;
        }
        return ans;
    }
};