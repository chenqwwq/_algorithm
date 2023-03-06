//
// Created by chenqwwq on 2022/12/1.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

class Solution {
    int getDis(int x, int y, int i, int j) {
        return abs(x - i) + abs(y - j);
    }

public:
    int nearestValidPoint(int x, int y, vector<vector<int>> &points) {
        int n = points.size();
        int ans = -1, md = 0x3f3f3f3f;
        for (int i = 0;i < n;i++){
            if (x == points[i][0] || y == points[i][1]) {
                int dis = getDis(x, y, points[i][0], points[i][1]);
                if(dis < md){
                    ans = i;
                    md = dis;
                }
            }
        }
        return ans;
    }
};