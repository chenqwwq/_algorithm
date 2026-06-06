//
// Created by chenqwwq on 2024/6/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumChairs(string s) {
        int cur = 0, ans = 0;
        for (char c: s) {
            if (c == 'E') ans = max(++cur, ans);
            else --cur;
        }
        return ans;
    }

    int max(int a, int b) {
        return a > b ? a : b;
    }
};