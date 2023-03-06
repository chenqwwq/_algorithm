//
// Created by chenqwwq on 2022/12/27.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
private:
    int mod = 1e9 + 7;
public:
    int countHomogenous(string s) {
        int n = (int) s.size();
        long long ans = 0;
        long long c = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1]) c++;
            else {
                ans = (ans + c * (c + 1) / 2) % mod;
                c = 1;
            }
        }
        ans = (ans + c * (c + 1) / 2) % mod;
        return (int)ans;
    }
};