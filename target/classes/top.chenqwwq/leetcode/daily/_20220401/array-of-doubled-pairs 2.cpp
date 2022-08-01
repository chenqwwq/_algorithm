//
// Created by 陈炳鑫 on 2022/4/1.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool canReorderDoubled(vector<int> &arr) {
        auto comp = [](int n1, int n2) -> bool {
            return abs(n1) > abs(n2);
        };
        priority_queue<int, vector<int>, decltype(comp)> pq(comp);
        unordered_map<int, int> del;
        int cnt = 0;
        for (int num: arr) pq.push(num);

        while (!pq.empty()) {
            int cur = pq.top();
            pq.pop();
            if (del[cur] > 0) {
                del[cur]--;
                cnt--;
            } else {
                cnt++;
                del[cur * 2]++;
            }
        }
        return cnt == 0;
    }
};