//
// Created by chenqwwq on 2023/1/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
    string pattern = "!@#$%^&*()-+";
public:
    bool strongPasswordCheckerII(string password) {
        int n = (int) password.size();
        if (n < 8) return false;
        bool a = false, b = false, c = false, d = false, e = true;
        for (int i = 0; i < n; i++) {
            if (password[i] >= 'a' && password[i] <= 'z') a = true;
            else if (password[i] >= 'A' && password[i] <= 'Z') b = true;
            else if (password[i] >= '0' && password[i] <= '9') c = true;
            else if (any_of(pattern.begin(), pattern.end(), [&](char cc) { return cc == password[i]; })) d = true;
            if (i > 0 && password[i] == password[i - 1]) e = false;
        }
        return a && b && c && d && e;
    }
};