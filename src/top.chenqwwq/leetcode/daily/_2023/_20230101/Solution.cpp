//
// Created by chenqwwq on 2023/1/1.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    char repeatedCharacter(string s) {
        bool hash[26];
        ::memset(hash, false, sizeof hash);
        for (char c: s) {
            if (hash[c - 'a']) return c;
            hash[c - 'a'] = true;
        }
        return ' ';
    }
};