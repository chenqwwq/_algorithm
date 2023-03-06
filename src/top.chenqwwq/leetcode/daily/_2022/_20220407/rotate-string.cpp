//
// Created by 陈炳鑫 on 2022/4/7.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool rotateString(string s, string goal) {
        if (s.size() != goal.size()) return false;
        return (goal + goal).find(s) != string::npos;
    }
};