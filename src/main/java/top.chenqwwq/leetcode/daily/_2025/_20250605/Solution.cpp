//
// Created by chenqwwq on 2025/6/5.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        int fa[26];
        fill(fa, fa + 26, 0);

        auto find = [&](auto find, int x) {
            if (fa[x] == 0) return x;
            return fa[x] = find(find, fa[x]);
        };

        auto merge = [&](int x, int y) {
            // 把大的代表元指向小的代表元
            auto [small, big] = minmax(find(find, x), find(find, y));
            fa[big] = small;
        };

        for (int i = 0; i < s1.size(); i++) {
            merge(s1[i] - 'a', s2[i] - 'a');
        }

        for (int i = 0; i < baseStr.size(); i++) {
            baseStr[i] = find(find, baseStr[i] - 'a') + 'a';
        }
        return baseStr;
    }
};