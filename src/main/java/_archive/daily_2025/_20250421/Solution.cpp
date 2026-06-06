//
// Created by chenqwwq on 2025/4/21.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numberOfArrays(vector<int> &differences, int lower, int upper) {
        long long min = 0ll, max = 0ll;
        long long cur = 0;
        for (int difference: differences) {
            cur += difference;
            min = std::min(min, cur);
            max = std::max(max, cur);
        }
        return (int)(std::max(upper - lower - (max - min) + 1, 0ll));
    }
};