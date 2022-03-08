//
// Created by 陈炳鑫 on 2022/3/5.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int findLUSlength(string a, string b) {
        return a == b ? -1 : max(a.length(), b.length());
    }
};