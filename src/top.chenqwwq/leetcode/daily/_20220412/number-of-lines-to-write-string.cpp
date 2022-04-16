//
// Created by 陈炳鑫 on 2022/4/12.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> numberOfLines(vector<int> &widths, string s) {
        int ans = 0, curr = 0;
        for (char c: s) {
            if (curr + widths[c - 'a'] > 100) {
                ans++;
                curr = widths[c - 'a'];
            } else curr += widths[c - 'a'];
        }
        return {ans + 1, curr};
    }
};