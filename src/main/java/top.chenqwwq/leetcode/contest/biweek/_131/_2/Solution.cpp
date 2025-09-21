//
// Created by chenqwwq on 2024/5/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> occurrencesOfElement(vector<int> &nums, vector<int> &queries, int x) {
        unordered_map<int, int> v2i;
        for (int i = 0, cnt = 1; i < nums.size(); i++) {
            if (nums[i] == x)v2i[cnt++] = i;
        }
        vector<int> ans(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = v2i.find(queries[i]) == v2i.end() ? -1 : v2i[queries[i]];
        }
        return ans;
    }
};