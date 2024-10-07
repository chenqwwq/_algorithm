//
// Created by chenqwwq on 2024/5/22.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>> &matches) {
        unordered_map<int, int> map;
        unordered_set<int> set;
        for (auto match: matches) {
            set.insert(match[0]);
            set.insert(match[1]);
            map[match[1]]++;
        }
        vector<vector<int>> ans(2, vector<int>());
        for (auto m: set) {
            // 没找到说明没输过
            if (map.find(m) == map.end()) {
                ans[0].push_back(m);
            } else if (map[m] == 1) {
                ans[1].push_back(m);
            }
        }
        sort(ans[0].begin(), ans[0].end());
        sort(ans[1].begin(), ans[1].end());
        return ans;
    }
};