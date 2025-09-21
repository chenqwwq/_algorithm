//
// Created by chenqwwq on 2025/5/22.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxRemoval(vector<int> &nums, vector<vector<int>> &queries) {
        auto n = nums.size(), m = queries.size();

        // 按照左端升序排列
        sort(queries.begin(), queries.end(), [](auto &a, auto &b) { return a[0] < b[0]; });
        // 用于保存所有左端点小于当前值的序列的右端点
        priority_queue<int> pq;
        vector<int> diff(n + 1, 0);
        // cur 表示当前值
        // j 表示 queries 的下标
        int cur = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cur += diff[i];

            // 把左端点小于i的都塞进去
            while (j < m && queries[j][0] <= i) {
                pq.push(queries[j++][1]);
            }

            // 贪心选择右端点最大的
            while (cur < nums[i] && !pq.empty() && pq.top() >= i) {
                cur++;
                diff[pq.top() + 1]--;
                pq.pop();
            }

            // 当前大小构建不出来
            if (cur < nums[i]) return -1;
        }
        return pq.size();
    }
};