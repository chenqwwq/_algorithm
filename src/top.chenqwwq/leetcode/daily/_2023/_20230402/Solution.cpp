//
// Created by chenqwwq on 2023/4/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minScoreTriangulation(vector<int> &values) {
        int n = (int) values.size();
        int memo[n][n];
        ::memset(memo, 0, sizeof(memo));
        function<int(int, int)> dfs;
        dfs = [&](int i, int j) -> int {
            if (i + 1 == j) return 0;
            if (memo[i][j]) return memo[i][j];
            int num = 0x3f3f3f3f;
            for (int k = i + 1; k < j; k++) {
                num = min(num,dfs(i,k) + dfs(k,j) + values[i]*values[j] * values[k]);
            }
            return  memo[i][j] = num;
        };
        return dfs(0,n-1);
    }
};