//
// Created by chenqwwq on 2025/6/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<vector<int>> minAbsDiff(vector<vector<int>> &grid, int k) {
        auto n = grid.size(), m = grid[0].size();
        auto q = n - k + 1, p = m - k + 1;
        vector<vector<int>> ans(q, vector<int>(p));
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < p; j++) {
                int mv = INT_MAX;
                // 外层
                for (int e = 0; e < k; e++) {
                    for (int f = 0; f < k; f++) {
                        int num = grid[i + e][j + f];
                        // 内层
                        for (int a = 0; a < k; a++) {
                            for (int b = 0; b < k; b++) {
                                if (a == e && b == f) continue;
                                auto num2 = grid[i + a][j + b];
                                if(num == num2) continue;
                                mv = min(mv, abs(num - num2));
                            }
                        }
                    }
                }
                ans[i][j] = mv == INT_MAX ? 0 : mv;
            }
        }
        return ans;
    }
};

int main() {
    vector<vector<int>> v = {{1, -2, 3},
                             {2, 3,  5}};
    (new Solution)->minAbsDiff(v, 2);
}