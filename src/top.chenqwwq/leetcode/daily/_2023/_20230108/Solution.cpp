//
// Created by chenqwwq on 2023/1/8.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int prefixCount(vector<string> &words, string pref) {
        int ans = 0, n = (int) pref.size();
        for (const string &word: words) {
            if (word.compare(0, n, pref) == 0) {
                ans++;
            }
        }
        return ans;
    }
};