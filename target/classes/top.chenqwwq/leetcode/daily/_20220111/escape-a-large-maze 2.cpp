//
// Created by chenqwwq on 2022/1/11.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int N, MAX, EDGE = 1e6;
    unordered_set<long> bs;
    int cx[4]{1, -1, 0, 0},
            cy[4]{0, 0, 1, -1};


    bool isEscapePossible(vector<vector<int>> &blocked, vector<int> &source, vector<int> &target) {
        // 范围 1e6，爆搜直接躺
        // 判断 blocked 是否包围其中一个点，并且另外一个点不再包围圈
        // blocked 最大有200个点，最大是和边角一起包含
        // 最大面积为  n(n-1) / 2
        N = blocked.size();
        if (N < 2) return true;
        MAX = N * (N - 1) >> 1;
        for (auto &v: blocked) bs.insert(get(v[0], v[1]));
        return check(source[0], source[1], target[0], target[1])
               && check(target[0], target[1], source[0], source[1]);
    }

    bool check(int x, int y, int tx, int ty) {
        set<long> vis;
        queue<pair<int, int>> qu;
        qu.push({x, y});
        bs.insert(get(x, y));
        while (!qu.empty() && vis.size() < MAX) {
            auto front = qu.front();
            qu.pop();
            int a = front.first, b = front.second;
            for (int i = 0; i < 4; ++i) {
                int c = a + cx[i], d = b + cy[i];
                if (c == tx && d == ty) return true;
                if (c < 0 || c >= EDGE || d < 0 || d >= EDGE) continue;
                long mask = get(c, d);
                if (vis.count(mask)) continue;
                if (bs.count(mask)) continue;
                qu.push({c, d});
                vis.insert(mask);
            }
        }
        return vis.size() >= MAX;
    }

    long get(int x, int y) {
        return (long) x << 32 | y;
    }
};

int main(){
    Solution *pSolution = new Solution;
    vector<vector<int>> p1 = {{629173,232687},{695376,426436},{164553,460497},{956954,310238},{322182,515846},{847558,240198},{792551,770487},{4146,573081},{397773,751953},{899296,153588},{731578,860293},{616566,678204},{731801,813001},{68606,163479},{839668,109780},{57126,967537}};
    bool b = pSolution->isEscapePossible(p1, *new vector<int>{603201, 575992}, *new vector<int>{765501, 302566});
    cout << b << endl;
}