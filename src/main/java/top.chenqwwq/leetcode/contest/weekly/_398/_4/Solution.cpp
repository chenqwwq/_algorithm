//
// Created by chenqwwq on 2024/5/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
    unordered_map<long long, int> memo;
public:
    int waysToReachStair(int k) {
        return dfs(1, 0, false);
    }

    long long dfs(int i, int j, bool action) {
    }
};