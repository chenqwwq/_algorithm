//
// Created by 陈炳鑫 on 2022/1/10.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool checkValid(vector<vector<int>> &matrix) {
        int n = matrix.size();
        bool hash[n + 1];
        for (int i = 0; i < n; ++i) {
            memset(hash, false, n + 1);
            for (int j = 0; j < n; ++j) {
                if (hash[matrix[i][j]]) {
                    return false;
                }
                hash[matrix[i][j]] = true;
            }
        }

        for (int i = 0; i < n; ++i) {
            memset(hash, false, n + 1);
            for (int j = 0; j < n; ++j) {
                if (hash[matrix[j][i]]) {
                    return false;
                }
                hash[matrix[j][i]] = true;
            }
        }
        return true;
    }
};