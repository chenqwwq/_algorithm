//
// Created by chenqwwq on 2024/7/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numberOfSubmatrices(vector<vector<char>> &grid) {
        auto x = grid.size(), y = grid[0].size();
        int ans = 0;
        vector<vector<vector<int>>> sum(x, vector<vector<int>>(y, vector<int>(2, 0)));
        sum[0][0][0] = grid[0][0] == 'X' ? 1 : 0;
        sum[0][0][1] = grid[0][0] == 'Y' ? 1 : 0;
        for (int i = 1; i < y; i++) {
            sum[0][i][0] = sum[0][i - 1][0] + (grid[0][i] == 'X' ? 1 : 0);
            sum[0][i][1] = sum[0][i - 1][1] + (grid[0][i] == 'Y' ? 1 : 0);
            if (sum[0][i][0] && sum[0][i][0] == sum[0][i][1]) ans++;
        }
        for (int i = 1; i < x; i++) {
            sum[i][0][0] = sum[i - 1][0][0] + (grid[i][0] == 'X' ? 1 : 0);
            sum[i][0][1] = sum[i - 1][0][1] + (grid[i][0] == 'Y' ? 1 : 0);
            if (sum[i][0][0] && sum[i][0][0] == sum[i][0][1]) ans++;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                sum[i][j][0] =
                        sum[i - 1][j][0] + sum[i][j - 1][0] - sum[i - 1][j - 1][0] + (grid[i][j] == 'X' ? 1 : 0);
                sum[i][j][1] =
                        sum[i - 1][j][1] + sum[i][j - 1][1] - sum[i - 1][j - 1][1] + (grid[i][j] == 'Y' ? 1 : 0);
                if (sum[i][j][0] && sum[i][j][0] == sum[i][j][1]) ans++;
            }
        }
        return ans;
    }
};

int main() {
    vector<vector<char>> grid(2);
    grid[0] = {'X', 'Y', '.'};
    grid[1] = {'Y', '.', '.'};
    (new Solution)->numberOfSubmatrices(grid);
}
