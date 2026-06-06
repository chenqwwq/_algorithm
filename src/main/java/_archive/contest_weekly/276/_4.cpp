//
// Created by chenqwwq on 2022/1/16.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    long long maxRunTime(int n, vector<int> &batteries) {
        long long sum = 0;
        for (auto battery: batteries) {
            sum += battery;
        }
        if (sum < n) {
            return 0;
        }
        int l = 1, r = sum / n;
    }
};