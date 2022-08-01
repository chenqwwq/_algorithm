//
// Created by chenqwwq on 2022/1/14.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    unordered_map<string, unordered_map<string, double>> path;

    vector<double>
    calcEquation(vector<vector<string>> &equations, vector<double> &values, vector<vector<string>> &queries) {
        auto n = equations.size();

        for (int i = 0; i < n; ++i) {
            if (path.find(equations[i][0]) == path.end()) {
                unordered_map<string, double> tmp;
                tmp[equations[i][1]] = values[i];
                path[equations[i][0]] = tmp;
            } else {
                path[equations[i][0]][equations[i][1]] = values[i];
            }

            if (path.find(equations[i][1]) == path.end()) {
                unordered_map<string, double> tmp;
                tmp[equations[i][0]] = 1 / values[i];
                path[equations[i][1]] = tmp;
            } else {
                path[equations[i][1]][equations[i][0]] = 1 / values[i];
            }
        }

        auto m = queries.size();
        vector<double> ans;
        for (auto query: queries) {
            unordered_set<string> vis;
            ans.push_back(cal(query[0], query[1], 1.0, &vis));
        }
        return ans;
    }

    // 题目确保无环,并且输入有效
    double cal(const string &start, const string &end, double cur, unordered_set<string> *vis) {
        vis->insert(start);
        if (path.find(start) == path.end()) {
            return -1.0;
        }
        if (start == end) {
            return 1.0;
        }
        auto second = path[start];
        if (second.find(end) != second.end()) {
            return cur * second[end];
        }
        for (auto[key, val]: second) {
            if (vis->count(key)) {
                continue;
            }
            if (path.find(key) == path.end()) {
                continue;
            }
            double res = cal(key, end, cur * val, vis);
            if (res != -1.0) {
                return res;
            }
        }

        return -1.0;
    }
};
