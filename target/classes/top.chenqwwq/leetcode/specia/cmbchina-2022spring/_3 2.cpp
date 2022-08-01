//
// Created by 陈炳鑫 on 2022/4/10.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int numFlowers(vector<vector<int>> &roads) {
        int n = roads.size() + 1;
        vector<int> dg(n);
        for (auto road: roads) {
            dg[road[0]]++;
            dg[road[1]]++;
        }
        return max_element(dg.begin(), dg.end()).operator*() + 1;
    }
};