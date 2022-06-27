//
// Created by 陈炳鑫 on 2022/4/6.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>> &edges) {

    }

//        vector<int> findMinHeightTrees(int n, vector<vector<int>> &edges) {
//        // 建图
//        vector<vector<int>> graph;
//        for (auto edge: edges) {
//            int a = edge[0], b = edge[1];
//            graph[a].emplace_back(b);
//            graph[b].emplace_back(a);
//        }
//
//        // bfs
//        deque<int> dq;
//        vector<bool> vis(n, false);
//        int mmin = 0x3F3F3F3F;
//        vector<int> ans;
//        for (int i = 0; i < n; ++i) {
//            vis.assign(n, false);
//            dq.push_back(i);
//            bool suc = true;
//            vis[i] = true;
//            int dep = 0;
//            while (!dq.empty()) {
//                if (++dep > mmin || dep > (n >> 1)){
//                    suc = false;
//                    break;
//                }
//                int size = (int) dq.size();
//                while (size--) {
//                    int cur = dq.front();
//                    dq.pop_front();
//                    for (auto v: graph[cur]) {
//                        if (vis[v]) continue;
//                        vis[v] = true;
//                        dq.push_back(v);
//                    }
//                }
//            }
//            dq.clear();
//            if(!suc) continue;
//            if (dep == mmin) ans.push_back(i);
//            else if (dep < mmin) {
//                mmin = dep;
//                ans.clear();
//                ans.push_back(i);
//            }
//        }
//        return ans;
//    }
};