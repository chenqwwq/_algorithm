//
// Created by chenqwwq on 2024/6/6.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long minimumSteps(string s) {
        long long ans = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '0')ans += (i - cur++);
        }
        return ans;
    }
};