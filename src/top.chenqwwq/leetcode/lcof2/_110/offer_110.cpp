//
// Created by chenqwwq on 2022/1/13.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    vector<vector<int>> ans;
    int target = 0;
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>> &graph) {
        target = graph.size() - 1;
        vector<int> tmp = {0};
        dfs(graph, 0, tmp);
        return ans;
    }

    void dfs(vector<vector<int>> &graph, int curr, vector<int> &path) {
        if (target == curr) {
            ans.push_back(move(path));
            return;
        }
        for (auto next: graph[curr]) {
            path.push_back(next);
            dfs(graph, next, path);
            path.pop_back();
        }
    }
};