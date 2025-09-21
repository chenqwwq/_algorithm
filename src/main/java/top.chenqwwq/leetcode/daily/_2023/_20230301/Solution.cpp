//
// Created by chenqwwq on 2023/3/1.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int cc[3]{-1, 0, 1};

    vector<vector<int>> largestLocal(vector<vector<int>> &grid) {
        int n = (int) grid.size();
        vector<vector<int>> ans(n - 2);
        for (int i = 0; i < n - 2; i++) ans[i] = vector<int>(n - 2, 0);
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int q: cc) {
                    for (int p: cc) {
                        ans[i][j] = max(ans[i][j], grid[i + 1 + q][j + 1 + p]);
                    }
                }
            }
        }
        return ans;
    }
};