//
// Created by chenqwwq on 2025/10/7.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> avoidFlood(vector<int> &rains) {
        auto n = rains.size();

        set<int> os; // 记录可以排水的下标
        unordered_map<int, int> map;
        vector ans(n, -1); // 返回结果

        for (int i = 0; i < n; i++) {
            const int idx = rains[i];
            if (idx == 0) os.emplace(i);
            else {
                if (map.find(idx) != map.end()) {
                    if (os.empty()) return {};
                    auto k = os.upper_bound(map[idx]);
                    if (k == os.end()) return {};
                    ans[*k] = rains[i];
                    os.erase(*k);
                }
                map[idx] = i;
            }
        }

        for (const int i: os) ans[i] = 1;
        return ans;
    }
};

int main() {
    vector rains = {1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3};
    (new Solution)->avoidFlood(rains);
}