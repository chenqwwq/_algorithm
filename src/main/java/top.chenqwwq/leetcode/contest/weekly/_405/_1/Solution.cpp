//
// Created by chenqwwq on 2024/7/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string getEncryptedString(string s, int k) {
        auto n = s.length();
        string ans = "";
        for (int i = 0; i < n; i++) {
            ans += s[(i + k) % n];
        }
        return ans;
    }
};