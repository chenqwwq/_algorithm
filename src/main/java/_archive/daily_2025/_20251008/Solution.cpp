//
// Created by chenqwwq on 2025/10/8.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> successfulPairs(vector<int> &ss, vector<int> &ps, long long success) {
        int n = ss.size(), m = ps.size();
        sort(ps.begin(), ps.end());
        // 两边都大于0,直接二分
        auto h = [&](int x) {
            int l = 0, r = m;
            while (l < r) {
                int mid = (l + r) / 2;
                if (1ll * ps[mid] * x >= success) r = mid;
                else l = mid + 1;
            }
            return m - l;
        };

        vector ans(n, 0);
        for (int i = 0; i < n; i++) {
            ans[i] = h(ss[i]);
        }
        return ans;
    }
};