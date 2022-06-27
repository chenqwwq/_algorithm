//
// Created by chenqwwq on 2022/5/29.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>> &roads) {
        map<int, int> h;
        for (auto &road: roads) {
            h[road[0]]++;
            h[road[1]]++;
        }
        vector<pair<int, int>> pairs(h.begin(), h.end());
        sort(pairs.begin(), pairs.end(), [](auto p1, auto p2) {
            return p1.second < p2.second;
        });
        long long ans = 0;
        for (auto [k, v]: pairs) {
            ans += (v * n--);
        }
        return ans;
    }
};