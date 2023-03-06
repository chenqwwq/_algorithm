//
// Created by chenqwwq on 2023/1/3.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool areNumbersAscending(string s) {
        // 1 box has 3 blue 4 red 6 green and 12 yellow marbles
        int n = (int) s.size();
        int cur = -1, pre = -1;
        for (int i = 0; i < n; i++) {
            if (!isNumber(s[i])) {
                if(cur == -1) continue;
                if (cur <= pre) return false;
                pre = cur;
                cur = -1;
            } else {
                cur = max(cur,0) * 10 + (s[i] - '0');
            }
        }
        return cur == -1 || cur > pre;
    }

    bool isNumber(char c) {
        return c >= '0' && c < '9';
    }
};