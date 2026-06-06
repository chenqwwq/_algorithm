//
// Created by 陈炳鑫 on 2022/4/27.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int cx[4] = {1, -1, 0, 0}, cy[4] = {0, 0, 1, -1};
    int n, m;

    vector<vector<int>> pacificAtlantic(vector<vector<int>> &h) {
        n = (int) h.size();
        m = (int) h[0].size();

        deque<vector<int>> hh;
        vector<vector<bool>> a1(n, vector<bool>(m, false));
        for (int i = 0; i < m; ++i) {
            hh.push_back({0, i});
            a1[0][i] = true;
        }
        for (int i = 1; i < n; ++i) {
            hh.push_back({i, 0});
            a1[i][0] = true;
        }
        bfs(h,hh, a1);

        vector<vector<bool>> a2(n, vector<bool>(m, false));
        for (int i = 0; i < m; ++i) {
            hh.push_back({n - 1, i});
            a2[n - 1][i] = true;
        }
        for (int i = 1; i < n; ++i) {
            hh.push_back({i, m - 1});
            a2[i][m - 1] = true;
        }
        bfs(h,hh, a2);

        vector<vector<int>> ans;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (a1[i][j] && a2[i][j]) ans.push_back({i, j});
            }
        }
        return ans;
    }

    void bfs(vector<vector<int>> &h,deque<vector<int>> &ss, vector<vector<bool>> &vis) {
        while (!ss.empty()) {
            auto front = ss.front();
            ss.pop_front();
            int x = front[0], y = front[1];
            for (int i = 0; i < 4; ++i) {
                int a = x + cx[i], b = y + cy[i];
                if (a < 0 || b < 0 || a >= n || b >= m || vis[a][b]) continue;
                if (h[a][b] < h[x][y]) continue;
                vis[a][b] = true;
                ss.push_back({a, b});
            }
        }
    }
};