//
// Created by 陈炳鑫 on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        auto n = s.length();
        string tmp = "";
        vector<string> ans;
        for (int i = 0; i < n; ++i) {
            tmp += s[i];
            if (tmp.length() == k) {
                ans.push_back(tmp);
                tmp = "";
            }
        }
        while (tmp.length() != 0 && tmp.length() < k) {
            tmp += fill;
        }
        if (tmp.length() != 0) {
            ans.push_back(tmp);
        }
        return ans;
    }
};