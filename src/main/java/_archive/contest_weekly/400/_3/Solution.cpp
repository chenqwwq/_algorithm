//
// Created by chenqwwq on 2024/6/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string clearStars(string s) {

        // 分26个栈记录节点位置
        vector<int> vs[26];
        for (auto &v: vs)v = {};
        for (int i = 0; i < s.length(); i++) {
            if (s[i] != '*') {
                vs[s[i] - 'a'].push_back(i);
            } else {
                for (auto &v: vs) {
                    if (!v.empty()) {
                        v.pop_back();
                        break;
                    }
                }
            }
        }

        vector<int> idx;
        for (auto &p: vs) {
            idx.insert(idx.end(), p.begin(), p.end());
        }
        sort(idx.begin(), idx.end());
        string t(idx.size(), 0);
        for (int i = 0; i < idx.size(); i++) {
            t[i] = s[idx[i]];
        }
        return t;
    }
};