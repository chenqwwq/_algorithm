//
// Created by chenqwwq on 2023/3/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>> &roads) {
        vector<vector<bool>> mmap(n, vector<bool>(n, false));
        vector<int> d(n, 0);
        for (auto road: roads) {
            d[road[0]]++;
            d[road[1]]++;
            mmap[road[0]][road[1]] = true;
            mmap[road[1]][road[0]] = true;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = max(ans, d[i] + d[j] - (mmap[i][j] ? 1 : 0));
            }
        }
        return ans;
    }
};