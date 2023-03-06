//
// Created by 陈炳鑫 on 2022/4/19.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        int n = (int) s.length();
        vector<int> ans(n, 0x3f3f3f3f);
        int pre = 0x3f3f3f3f;
        for (int i = 0; i < n; ++i) {
            if (s[i] == c) {
                ans[i] = 0;
                for (int j = i - 1; j >= 0; --j) {
                    int dis = i - j;
                    if (ans[j] < dis) break;
                    ans[j] = dis;
                }
                pre = 0;
            } else {
                ans[i] = ++pre;
            }
        }
        return ans;
    }
};