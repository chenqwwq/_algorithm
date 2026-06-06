//
// Created by 陈炳鑫 on 2022/4/19.
//


#include <iostream>
#include <unordered_map>
#include <vector>
#include <deque>
#include <functional>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    unordered_map<int, vector<int>> graph;
    int a, b;
    for (int i = 0; i < n - 1; ++i) {
        scanf("%d %d", &a, &b);
        a--;
        b--;
        if (graph.find(a) == graph.end()) graph[a] = {};
        if (graph.find(b) == graph.end()) graph[b] = {};
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    int mmax = 0;
    vector<int> ans;
    deque<int> dq;
    function<int(vector<bool> &v, int i)> dfs;
    dfs = [&](vector<bool> &v, int i) -> int {
        bool cycle = false;
        dq.push_back(i);
        v[i] = true;
        int cnt = 1, level = 0;
        while (!dq.empty()) {
            level++;
            int size = dq.size();
            for (int j = 0; j < size; ++j) {
                auto cur = dq.front();
                dq.pop_front();
                int qq = 0;
                for (auto next: graph[cur]) {
                    if (v[next]) {
                        if (++qq > 1) cycle = true;
                        continue;
                    }
                    cnt++;
                    dq.push_back(next);
                    v[next] = true;
                }
            }
        }
        return (cycle || cnt != n) ? -1 : level;
    };

    for (int i = 0; i < n; ++i) {
        vector<bool> vis(n, false);
        int ret = dfs(vis, i);
        if (ret == -1) {
            int cs = 1;
            for (int j = 0; j < n; ++j) {
                if (vis[j]) continue;
                vis[j] = true;
                dfs(vis, j);
                cs++;
            }
            printf("Error: %d components", cs);
            return 0;
        } else if (ret > mmax) {
            mmax = ret;
            ans.clear();
            ans.push_back(i);
        } else if (ret == mmax) {
            ans.push_back(i);
        }
    }
    for (int an: ans) printf("%d\n", an + 1);
    return 0;
}