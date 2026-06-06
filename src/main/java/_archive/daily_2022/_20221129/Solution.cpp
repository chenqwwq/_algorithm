//
// Created by chenqwwq on 2022/11/29.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

class Solution {
public:
    int minOperations(string s) {
        return min(check(s, 0), check(s, 1));
    }

    int check(string s, int i) {
        int cnt = 0;
        for (char c: s) {
            if (c - '0' != i) cnt++;
            i ^= 1;
        }
        return cnt;
    }
};