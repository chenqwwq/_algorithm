//
// Created by chenqwwq on 2023/2/28.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>> &items1, vector<vector<int>> &items2) {
        map<int, int> vw;
        for (auto &item: items1) {
            vw[item[0]] += item[1];
        }
        for (auto &item: items2) {
            vw[item[0]] += item[1];
        }

        vector<vector<int>> ret;
        for (auto &v: vw) {
            ret.push_back({v.first, v.second});
        }
        sort(ret.begin(), ret.end(), [](vector<int> &v1, vector<int> &v2) {
            return v1[0] < v2[0];
        });
        return ret;
    }
};