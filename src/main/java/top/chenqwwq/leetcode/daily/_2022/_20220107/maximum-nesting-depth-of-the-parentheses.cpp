//
// Created by chenqwwq on 2022/1/7.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxDepth(string s) {
        int ans = 0, curr = 0;
        for (char &c: s) {
            if (c == '(') {
                curr++;
                if (ans < curr) {
                    ans = curr;
                }
            } else if (c == ')') {
                curr--;
            }
        }
        return ans;
    }
};