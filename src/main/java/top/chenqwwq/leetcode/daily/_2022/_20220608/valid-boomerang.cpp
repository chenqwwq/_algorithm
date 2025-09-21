//
// Created by chenqwwq on 2022/6/8.
//


#include "bits/stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;

class Solution {
public:
    bool isBoomerang(vector<vector<int>> &ps) {
        int x1 = ps[0][0], y1 = ps[0][1];
        int x2 = ps[1][0], y2 = ps[1][1];
        int x3 = ps[2][0], y3 = ps[2][1];
        return (y3 - y1) * (x2 - x1) != (y2 - y1) * (x3 - x1);
    }
};