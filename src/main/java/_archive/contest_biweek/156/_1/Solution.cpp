//
// Created by chenqwwq on 2025/5/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxFreqSum(string s) {
        vector<int> hash(26, 0);
        for (char c: s) hash[c - 'a']++;

        int a = 0, b = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') a = max(a, hash[c - 'a']);
            else b = max(b, hash[c - 'a']);
        }
        return a + b;
    }
};