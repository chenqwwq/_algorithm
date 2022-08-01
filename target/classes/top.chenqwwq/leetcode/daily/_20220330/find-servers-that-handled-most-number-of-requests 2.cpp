//
// Created by 陈炳鑫 on 2022/3/30.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;
typedef pair<int, int> pii;

class Solution {
public:
    vector<int> busiestServers(int k, vector<int> &arrival, vector<int> &load) {
        int n = arrival.size();
        // 任务结束时间-ServerID
        priority_queue<pii, vector<pii>, greater<>> loading;
        // ServerId
        set<int> free;
        for (int i = 0; i < k; ++i) free.insert(i);
        // 执行统计
        vector<int> cnts(k, 0);
        // 最大任务数
        int mmax = INT_MIN;
        for (int i = 0; i < n; ++i) {
            int start = arrival[i];
            while (!loading.empty() && loading.top().first <= start) {
                free.insert(loading.top().second);
                loading.pop();
            }
            if (free.empty()) continue;
            // 找到第一个大于i%k的服务Id
            auto sid = free.lower_bound(i % k);
            if (sid == free.end()) sid = free.begin();
            mmax = max(mmax, ++cnts[*sid]);
            loading.emplace(load[i] + start, *sid);
            free.erase(sid);
        }
        vector<int> ans;
        for (int i = 0; i < k; ++i) {
            if (cnts[i] == mmax) ans.push_back(i);
        }
        return ans;
    }
};