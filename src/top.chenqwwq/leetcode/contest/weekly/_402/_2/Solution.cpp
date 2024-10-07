//
// Created by chenqwwq on 2024/6/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long countCompleteDayPairs(vector<int> &hours) {
        long long ans = 0;
        long long cnts[24];
        memset(cnts, 0, sizeof(cnts));
        for (auto hour: hours) {
            cnts[hour % 24]++;
        }
        ans += com(cnts[0]);
        ans += com(cnts[12]);

        for (int i = 1; i < 12; i++) {
            ans += cnts[i] * cnts[24 - i];
        }

        return ans;
    }

private:
    long long com(int t) {
        if (t < 2) return 0;
        if (t == 2) return 1;
        long long ans = 1;
        for (int i = t; i >= t - 2 - 1; --i) {
            ans *= i;
        }
        return ans >> 1;
    }
};