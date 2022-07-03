//
// Created by 陈炳鑫 on 2022/4/10.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
    int mod = 1e9 + 7;
public:
    int maximumProduct(vector<int> &nums, int k) {
        priority_queue<int,vector<int>,greater<>> pq;
        for (auto num: nums) pq.push(num);
        while (k-- > 0) {
            int n = pq.top();
            pq.pop();
            pq.push(n + 1);
        }
        int ans = 1;
        while (!pq.empty()){
            ans = (1LL * ans * pq.top()) % mod;
            pq.pop();
        }
        return ans;
    }
};