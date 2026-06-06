//
// Created by chenqwwq on 2022/1/11.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int dx[4]{0, 0, 1, -1};
    int dy[4]{1, -1, 0, 0};

    vector<vector<int>> updateMatrix(vector<vector<int>> &mat) {
        int n = mat.size();
        if (n == 0) return {{}};
        int m = mat[0].size();
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) q.push({i, j});
                else mat[i][j] = -1;
            }
        }
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || mat[nx][ny] != -1) continue;
                mat[nx][ny] = mat[x][y] + 1;
                q.push({nx, ny});
            }
        }
        return mat;
    }
};