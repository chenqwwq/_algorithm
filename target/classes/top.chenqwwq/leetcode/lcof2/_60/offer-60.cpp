//
// Created by chenqwwq on 2022/1/18.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> topKFrequent(vector<int> &nums, int k) {
        // <num,cnt>
        unordered_map<int, int> hash;
        for (auto &num: nums) {
            hash[num]++;
        }

        auto comp = [&](int x, int y) -> bool {
            return hash[x] < hash[y];
        };
        priority_queue<int, vector<int>, decltype(comp)> q(comp);
        for (auto&[k, v]: hash) {
            q.push(k);
        }

        vector<int> ans(k);
        for (int i = 0; i < k; ++i) {
            ans[i] = q.top();
            q.pop();
        }
        return ans;
    }
};