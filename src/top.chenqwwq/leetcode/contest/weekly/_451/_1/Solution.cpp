//
// Created by chenqwwq on 2025/5/25.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long minCuttingCost(int n, int m, int k) {
        if (n > k && m > k) return -1;
        if (n > k) return (n - k) * k;
        return (m - k) * k;
    }
};