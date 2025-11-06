//
// Created by chenqwwq on 2025/10/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool scoreBalance(string s) {
        int total = 0;
        unordered_set<int> ss;
        for (char c: s) {
            total += (c - 'a');
            ss.insert(total);
        }

        return (total & 1) == 0 && ss.find(total / 2) != ss.end();
    }
};