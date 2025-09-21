//
// Created by chenqwwq on 2022/5/13.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int M, D;
    unordered_map<int, int> memo;

    int dfs(int sta, int sum, int cur) {
        if (memo.find(sta) != memo.end()) {
            return memo[sta];
        }
        for (int i = 0; i < M; ++i) {
            if ((sta >> i) & 1) continue;
            if (sum + i + 1 >= D || dfs(sta | (1 << i), sum + i + 1, -cur) == cur) {
                memo[sta] = cur;
                return cur;
            }
        }
        memo[sta] = -cur;
        return -cur;
    }

    bool canIWin(int m, int d) {
        if (m >= d) return true;
        if ((1 + m) * m / 2 < d) return false;
        M = m, D = d;
        return dfs(0, 0, 1) == 1;
    }
};