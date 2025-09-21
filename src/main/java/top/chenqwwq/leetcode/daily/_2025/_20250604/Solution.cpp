//
// Created by chenqwwq on 2025/6/4.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string answerString(string word, int m) {
        if(m == 1) return word;
        auto n = word.size();
        int len = n - m + 1;
        string ans = word.substr(0, len);
        for (int i = 1; i < n; i++) {
            string t = word.substr(i,len);
            if(ans < t) ans = t;
        }
        return ans;
    }
};