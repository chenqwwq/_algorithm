//
// Created by chenqwwq on 2024/5/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>> &queries) {
        // 每个球的颜色 和 每个颜色的球的个数
        unordered_map<int, int> col, i2c;
        int cnt = 0;
        vector<int> ans(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            auto query = queries[i];
            int x = query[0], y = query[1];
            // 获取原来的颜色
            int src = col.find(x) == col.end() ? -1 : col[x];
            if (src == y){
                ans[i] = cnt;
                continue;
            }
            // 原来颜色的个数
            int c = src == -1 ? 0 : i2c[src];
            // 原来颜色如果只有一个
            if (c == 1) cnt--;
            if (c > 0) --i2c[src];
            // 获取新颜色的个数
            if (++i2c[y] == 1) cnt++;
            col[x] = y;
            ans[i] = cnt;
        }
        return ans;
    }
};