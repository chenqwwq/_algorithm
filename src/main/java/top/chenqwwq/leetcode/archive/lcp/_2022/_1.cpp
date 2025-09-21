//
// Created by 陈炳鑫 on 2022/4/16.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int giveGem(vector<int> &gem, vector<vector<int>> &operations) {
        int n = (int) operations.size();
        for (auto op: operations) {
            int cnt = gem[op[0]] >> 1;
            gem[op[0]] -= cnt;
            gem[op[1]] += cnt;
        }
        int mmax = INT_MIN, mmin = INT_MAX;
        for (int g: gem) {
            mmax = max(mmax, g);
            mmin = min(mmin, g);
        }
        return mmax - mmin;
    }
};