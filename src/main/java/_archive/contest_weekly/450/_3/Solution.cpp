//
// Created by chenqwwq on 2025/5/18.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {

    int dirs[4][2] = {{0,  1},
                      {0,  -1},
                      {1,  0},
                      {-1, 0}};
public:
    int minMoves(vector<string> &matrix) {
        auto n = matrix.size(), m = matrix[0].size();
        // 终点就是障碍
        if (matrix[n - 1][m - 1] == '#') return -1;

        // 找到对应的字母
        vector<pair<int, int>> map[26]{};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isupper(matrix[i][j])) {
                    map[matrix[i][j] - 'A'].emplace_back(i, j);
                }
            }
        }


        vector<vector<int>> dis(n, vector<int>(m, 0x3f3f3f3f));
        dis[0][0] = 0;
        deque<pair<int, int>> deque{{0, 0}};

        while (!deque.empty()) {
            auto &[x, y] = deque.front();
            deque.pop_front();
            int d = dis[x][y];
            if (x == n - 1 && y == m - 1) return d;
            char cc = matrix[x][y];
            // 走传送门
            if (cc != '.') {    // # 的点位不会进队列
                // 使用传送门
                for (auto &[xx, yy]: map[cc - 'A']) {
                    if (d < dis[xx][yy]) {
                        dis[xx][yy] = d;  // 直接飞升的不需要+1
                        deque.emplace_front(xx, yy);
                    }
                }
                map[cc - 'A'].clear(); // 只走一次
            }

            // 不走传送门,往边上走
            for (auto &[q, p]: dirs) {
                int xx = x + q, yy = y + p;
                if (xx < 0 || yy < 0 || xx >= n || yy >= m || matrix[xx][yy] == '#') continue;
                if (d + 1 >= dis[xx][yy]) continue;
                dis[xx][yy] = d + 1;
                deque.emplace_back(xx, yy);
            }
        }
        return -1;
    }
};

int main() {
    vector<string> s{"BB.","...","AA#","B.."};
    auto ret = (new Solution)->minMoves(s);
    cout << ret << endl;
}