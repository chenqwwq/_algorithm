//
// Created by chenqwwq on 2022/1/14.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int> &nums1, vector<int> &nums2, int k) {
        vector<vector<int>> rets;

        auto cmp = [&nums1, &nums2](const pair<int, int> &p, const pair<int, int> &q) {
            return nums1[p.first] + nums2[p.second] > nums1[q.first] + nums2[q.second];
        };

        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)> pq(cmp);

        for (int i = 0; i < nums1.size(); i++) {
            pq.push({i, 0});
        }

        while (!pq.empty() && rets.size() < k) {
            auto p = pq.top();
            pq.pop();
            rets.push_back({nums1[p.first], nums2[p.second]});
            if (p.second < nums2.size() - 1) {
                pq.push(make_pair(p.first, p.second + 1));
            }
        }

        return rets;
    }
};