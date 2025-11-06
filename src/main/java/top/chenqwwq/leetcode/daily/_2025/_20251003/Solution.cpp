//
// Created by chenqwwq on 2025/10/3.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;


class Solution {
public:
    int trapRainWater(vector<vector<int> > &h) {
        // // 四向扫描不行,没办法只从四个方向考虑,
        // {12, 13, 1, 12},
        // {13, 4, 13, 12},
        // {13, 8, 10, 12},
        // {12, 13, 12, 12},
        // {13, 13, 13, 13}
        // 以上例子, [1,1] 只能接12
        // auto n = h.size(), m = h[0].size();
        // // 0,1 表示横向
        // // 2,3 表示纵向
        // auto scan = vector<vector<vector<int> > >(n, vector<vector<int> >(m, vector<int>(4, 0)));
        //
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         // 从左往右
        //         scan[i][j][0] = max(j > 0 ? scan[i][j - 1][0] : 0, h[i][j]);
        //         // 从右往左
        //         scan[i][m - j - 1][1] = max(j > 0 ? scan[i][m - j][1] : 0, h[i][m - j - 1]);
        //         // 从上往下
        //         scan[i][j][2] = max(i > 0 ? scan[i - 1][j][2] : 0, h[i][j]);
        //         // 从下往上
        //         scan[n - i - 1][j][3] = max(i > 0 ? scan[n - i][j][3] : 0, h[n - i - 1][j]);
        //     }
        // }
        // int ans = 0;
        // for (int i = 1; i < n - 1; i++) {
        //     for (int j = 1; j < m - 1; j++) {
        //         ans += max(*min_element(scan[i][j].begin(), scan[i][j].end()) - h[i][j], 0);
        //     }
        // }
        // return ans;
    }
};

int main() {
    vector<vector<int> > vv = {
        {12, 13, 1, 12},
        {13, 4, 13, 12},
        {13, 8, 10, 12},
        {12, 13, 12, 12},
        {13, 13, 13, 13}
    };
    (new Solution)->trapRainWater(vv);
}