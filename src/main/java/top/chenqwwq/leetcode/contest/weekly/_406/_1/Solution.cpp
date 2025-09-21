//
// Created by chenqwwq on 2024/7/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string getSmallestString(string s) {
        auto n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (!(abs(s[i] - s[i + 1]) & 1) && s[i] > s[i + 1]) {
                swap(s[i], s[i + 1]);
                return s;
            }
        }
        return s;
    }
};