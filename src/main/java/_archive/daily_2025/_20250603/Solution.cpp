//
// Created by chenqwwq on 2025/6/3.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxCandies(vector<int> &status, vector<int> &candies, vector<vector<int>> &keys,
                   vector<vector<int>> &containedBoxes, vector<int> &initialBoxes) {
        auto n = status.size();
        int ans = 0;
        vector<bool> has_key(n, false);
        vector<int> has_box(n, false);
        for (int box: initialBoxes) {
            has_box[box] = true;
        }

        auto dfs = [&](auto self, int cur) -> void {
            // 获得糖果
            ans += candies[cur];

            // 已经遍历过
            has_box[cur] = false;

            // 获得钥匙
            for (int key: keys[cur]) {
                has_key[key] = true;
                if (has_box[key]) {
                    self(self, key);
                }
            }

            // 包含的盒子
            for (int box: containedBoxes[cur]) {
                has_box[box] = true;
                if (has_key[box] || status[box]) {
                    self(self, box);
                }
            }
        };


        for (int box: initialBoxes) {
            if (status[box] && has_box[box]) {
                dfs(dfs, box);
            }
        }
        return ans;
    }
};