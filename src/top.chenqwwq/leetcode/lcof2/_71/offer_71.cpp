//
// Created by chenqwwq on 2022/1/11.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:

    int T;
    vector<int> ps;

    Solution(vector<int> &w) {
        int n = w.size();
        ps.resize(n);
        ps[0] = w[0];
        for (int i = 1; i < n; ++i) {
            ps[i] = w[i] + ps[i - 1];
        }
        T = ps[n - 1];
    }

    int pickIndex() {
        return upper_bound(ps.begin(),ps.end(),rand() % T) - ps.begin();
    }
};

