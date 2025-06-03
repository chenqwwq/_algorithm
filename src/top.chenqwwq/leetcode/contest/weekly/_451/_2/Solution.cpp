//
// Created by chenqwwq on 2025/5/25.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string resultingString(string s) {
        vector<char> vc;
        for (char c: s) {
            vc.emplace_back(c);
            auto t = vc.size();
            while (vc.size() >= 2 && (abs(vc[t - 1] - vc[t - 2]) == 1 || abs(vc[t - 1] - vc[t - 2]) == 25)) {
                vc.pop_back();
                vc.pop_back();
            }
        }

        return string(vc.begin(), vc.end());
    }
};