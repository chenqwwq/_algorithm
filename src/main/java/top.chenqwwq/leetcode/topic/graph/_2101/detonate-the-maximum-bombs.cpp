//
// Created by 陈炳鑫 on 2022/3/25.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maximumDetonation(vector<vector<int>> &bombs) {
        int n = bombs.size();
        unordered_map<int, vector<int>> graph;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (isConn(bombs[i], bombs[j])) {
                    if (graph.find(i) == graph.end()) graph[i] = {};
                    graph[i].push_back(j);
                }
            }
        }

        int ans = 1;
        vector<bool> exist(n, false);
        deque<int> dq;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            exist.assign(n, false);
            dq.push_back(i);
            exist[i] = true;
            while (!dq.empty()) {
                cnt++;
                int j = dq.front();
                dq.pop_front();
                for (int next: graph[j]) {
                    if (exist[next]) continue;
                    dq.push_back(next);
                    exist[next] = true;
                }
            }
            ans = max(ans, cnt);
        }
        return ans;
    }

    int isConn(vector<int> &p1, vector<int> &p2) {
        int a = p1[0], b = p1[1], c = p1[2];
        int x = p2[0], y = p2[1];
        return 1LL * (a - x) * (a - x) + 1LL * (b - y) * (b - y) <= 1LL * c * c;
    }
};