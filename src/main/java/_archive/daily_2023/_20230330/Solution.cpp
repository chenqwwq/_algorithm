//
// Created by chenqwwq on 2023/3/30.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxWidthOfVerticalArea(vector<vector<int>> &points) {
        int n = (int) points.size();
        sort(points.begin(), points.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, points[i+1][0] - points[i][0]);
        }
        return ans;
    }
};