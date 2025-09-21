//
// Created by chenqwwq on 2025/4/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;


class Solution {
public:
    long long calculateScore(vector<string> &instructions, vector<int> &values) {
        auto n = instructions.size();
        bool vis[n];
        memset(vis, false, sizeof(vis));
        int cur = 0;
        long long ans = 0;
        while (cur < n && cur >= 0 && !vis[cur]) {
            vis[cur] = true;
            if (instructions[cur] == "add"){
                ans += values[cur++];
            }
            else cur += values[cur];
        }
        return ans;
    }
};