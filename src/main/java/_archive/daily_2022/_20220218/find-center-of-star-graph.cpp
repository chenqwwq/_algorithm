//
// Created by chen on 2022/2/18.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int findCenter(vector<vector<int>> &edges) {
        unordered_map<int, int> indegree;
        for (auto edge: edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        for (auto[k, v]: indegree) {
            if (v > 1) return k;
        }
        return -1;
    }
};