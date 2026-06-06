//
// Created by chenqwwq on 2025/6/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int candy(vector<int> &ratings) {
        auto n = ratings.size();
        stack<int> nums;
        vector<int> v(n);
        for (int i = 0; i < n; i++) {
            if (!nums.empty() && ratings[nums.top()] <= ratings[i]) {
                int k = 1;
                while (!nums.empty()) {
                    int idx = nums.top();
                    nums.pop();
                    v[idx] = max(v[idx], k);
                    k = v[idx] + 1;
                }
            }
            nums.push(i);
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                v[i] = v[i - 1] + 1;
            }
        }
        int k = 1;
        while (!nums.empty()) {
            int idx = nums.top();
            nums.pop();
            v[idx] = max(v[idx], k);
            k = v[idx] + 1;
        }
        return accumulate(v.begin(), v.end(), 0);
    }
};