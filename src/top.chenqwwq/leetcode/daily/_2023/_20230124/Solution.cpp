//
// Created by chenqwwq on 2023/1/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    double getDis(int x, int y, int a, int b) {
        return (x - a) * (x - a) + (y - b) * (y - b);
    }

    vector<int> countPoints(vector<vector<int>> &points, vector<vector<int>> &queries) {
        int n = (int) queries.size();
        vector<int> ans(n, 0);
        for(int i = 0;i < n;i++){
            auto q = queries[i];
            for(auto p : points){
                if(getDis(q[0],q[1],p[0],p[1]) <= q[2] * q[2] ) ans[i]++;
            }
        }
        return ans;
    }
};