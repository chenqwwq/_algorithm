//
// Created by 陈炳鑫 on 2022/4/3.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>> &matches) {
        vector<vector<int>> ans(2, vector<int>{});
        vector<int> loss(100001), join(100001);
        for (auto v: matches) {
            loss[v[1]]++;
            join[v[1]]++;
            join[v[0]]++;
        }
        for (int i = 1; i <= 100000; ++i) {
            if (join[i] > 0) {
                if (loss[i] == 0) ans[0].push_back(i);
                else if (loss[i] == 1) ans[1].push_back(i);
            }
        }
        return ans;
    }
};