//
// Created by chenqwwq on 2023/1/16.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<string> split(string ss) {
        stringstream in(ss);
        string t;
        vector<string> ret;
        while (in >> t)ret.push_back(t);
        return ret;
    }

    bool areSentencesSimilar(string s1, string s2) {
        // 以单词作为最低粒度（不需要拆分为单个字符
        // 始终保持 s1 大于 s2 的情况
        if (s1.length() < s2.length()) return areSentencesSimilar(s2, s1);
        auto v1 = split(s1), v2 = split(s2);
        int l = 0, r1 = (int) v1.size() - 1, r2 = (int) v2.size() - 1;
        while (l < r2 && v1[l] == v2[l]) l++;
        while (r1 > l && r2 > l && v1[r1] == v2[r2]) {
            r1--;
            r2--;
        }
        return l + r2 == v2.size();
    };
};