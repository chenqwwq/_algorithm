//
// Created by chenqwwq on 2024/7/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<string> validStrings(int n) {
        find("0", 1, 0, n);
        find("1", 1, 1, n);
        return ans;
    }

    vector<string> ans = {};

    void find(string s, int cur, int pre, int n) {
        if (cur > n) {
            ans.push_back(s);
            return;
        }
        find(s + '1', cur + 1, 0, n);
        if (pre == 1) find(s + '0', cur + 1, 1, n);
    }
};