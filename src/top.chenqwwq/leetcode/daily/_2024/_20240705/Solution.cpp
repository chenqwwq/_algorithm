//
// Created by chenqwwq on 2024/7/5.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<vector<int>> modifiedMatrix(vector<vector<int>> &matrix) {
        auto n = matrix.size(), m = matrix[0].size();
        vector<int> ms(m, 0);
        for (auto nums: matrix) {
            for (int i = 0; i < m; i++) {
                ms[i] = max(ms[i], nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = ms[j];
                }
            }
        }
        return matrix;
    }
};