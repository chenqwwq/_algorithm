//
// Created by chenqwwq on 2022/1/18.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int> &nums1, vector<int> &nums2, int k) {
        auto n = nums1.size(), m = nums2.size();
        // 大顶堆
        auto comp = [&](const pair<int, int> &i, const pair<int, int> &j) {
            return i.first + i.second < j.first + j.second;
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)> q(comp);

        for (int i = 0; i < n && i < k; ++i) {
            for (int j = 0; j < m && j < k; ++j) {
                if (q.size() < k) {
                    q.push({nums1[i], nums2[j]});
                } else if (nums1[i] + nums2[j] < q.top().first + q.top().second) {
                    q.pop();
                    q.push({nums1[i], nums2[j]});
                }
            }
        }
        vector<vector<int>> ans;
        while (!q.empty()){
            ans.push_back({q.top().first,q.top().second});
            q.pop();
        }
        return ans;
    }
};