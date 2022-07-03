//
// Created by 陈炳鑫 on 2022/3/16.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int shortestSubarray(vector<int> &nums, int k) {
        auto n = nums.size();
        int ans = INT_MAX;
        long long sum = 0;
        deque<pair<int, int>> deq;
        deq.emplace_back(0,-1);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (sum > k) ans = min(ans, i + 1);

            // 删除所有比当前 sum 大的
            while (!deq.empty() && sum <= deq.back().first) deq.pop_back();

            while (!deq.empty() && sum - deq.front().first >= k) {
                ans = min(ans, i - deq.front().second);
                deq.pop_front();
            }
            deq.emplace_back(sum, i);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};

int main() {
    vector<int> v1{2, -1, 2};
    (new Solution)->shortestSubarray(v1, 3);
}