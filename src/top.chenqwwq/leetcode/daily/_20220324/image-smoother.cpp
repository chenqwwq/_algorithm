//
// Created by 陈炳鑫 on 2022/3/24.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>> &img) {
        int m = img.size(), n = img[0].size();
        vector<vector<int>> ans(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0, cnt = 0;
                for (int k = max(i - 1, 0); k <= min(i + 1, m - 1); ++k) {
                    for (int l = max(j - 1, 0); l <= min(j + 1, n - 1); ++l) {
                        cnt++;
                        sum += img[k][l];
                    }
                }
                ans[i][j] = sum / cnt;
            }
        }
        return ans;
    }
};
