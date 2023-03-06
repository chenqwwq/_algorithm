//
// Created by chenqwwq on 2023/1/11.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool digitCount(string num) {
        int hash[10];
        ::memset(hash, 0, sizeof hash);
        for (int i = 0; i < num.size(); i++) {
            hash[num[i] - '0']++;
            hash[i] -= num[i] - '0';
        }
        return all_of(hash, hash + 10, [&](int n) { return n == 0; });
    }
};