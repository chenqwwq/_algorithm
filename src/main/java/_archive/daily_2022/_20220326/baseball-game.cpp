//
// Created by 陈炳鑫 on 2022/3/26.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int calPoints(vector<string> &ops) {
        vector<int> stack;
        for (string c: ops) {
            auto n = stack.size();
            if (c == "+") stack.push_back(stack[n - 1] + stack[n - 2]);
            else if (c == "C") stack.pop_back();
            else if (c == "D") stack.push_back(2 * stack.back());
            else stack.push_back(atoi(c.c_str()));
        }

        return accumulate(stack.begin(), stack.end(), 0);
    }
};