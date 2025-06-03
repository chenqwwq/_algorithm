//
// Created by chenqwwq on 2025/6/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
    int dirs[4][2] = {{-1, 0},
                      {1,  0},
                      {0,  -1},
                      {0,  1}};

public:
    int minMoves(vector<string> &classroom, int energy) {
        auto n = classroom.size(), m = classroom[0].length();
        // 垃圾区 重置区
        int cnt = 0;
        unordered_map<int, int> xy2Cnt;
        int sx, sy;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (classroom[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (classroom[i][j] == 'L') {
                    xy2Cnt[i * m + j] = cnt++;
                }
            }
        }
        int u = 1 << cnt;
        vector<vector<vector<vector<int8_t>>>> vis(n, vector<vector<vector<int8_t>>>(m,
                                                                                     vector<vector<int8_t>>(energy + 1,
                                                                                                            vector<int8_t>(
                                                                                                                    u))));
        vis[sx][sy][energy][u - 1] = true;
        vector<array<int, 4>> stack{{sx, sy, energy, u - 1}};

        // BFS
        for (int ans = 0; !stack.empty(); ans++) {
            auto t = stack;
            stack.clear();
            // 遍历一层
            for (auto idx: t) {
                int x = idx[0], y = idx[1], e = idx[2], mask = idx[3];
                if (mask == 0) return ans;
                if (e == 0) continue;
                for (auto dir: dirs) {
                    int xx = dir[0], yy = dir[1];
                    int ex = x + xx, ey = y + yy;
                    if (ex < 0 || ex >= n || ey < 0 || ey >= m || classroom[ex][ey] == 'X') continue;
                    int nm = classroom[ex][ey] == 'L' ? mask & ~(1 << xy2Cnt[ex * m + ey]) : mask;
                    int ne = classroom[ex][ey] == 'R' ? energy : e - 1;
                    if (vis[ex][ey][ne][nm]) continue;
                    vis[ex][ey][ne][nm] = true;
                    stack.push_back({ex, ey, ne, nm});
                }
            }
        }

        return -1;
    }
};